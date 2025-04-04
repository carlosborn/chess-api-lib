package org.ceborn.http.impl;

import lombok.Getter;
import org.ceborn.http.TypeRequest;

import java.util.Date;
import java.util.Map;
import java.util.Optional;

@Getter
public class DataPlayerResponse extends AbstractResponse {

    private Long playerId;
    private Optional<String> title;
    private String id;
    private String url;
    private String username;
    private int followers;
    private String country;
    private Date lastOnline;
    private Date joined;
    private PlayerStatus status;
    private Optional<String> name;
    private Optional<String> avatar;
    private Optional<String> location;
    private boolean isStreamer;
    private Optional<String> twitchUrl;
    private Optional<Integer> fideRating;

    private DataPlayerResponse() {
    }

    public static DataPlayerResponseBuilder newBuilder() {
        return new DataPlayerResponseBuilder();
    }

    private void load() {
        this.playerId = this.getBody().getLong("player_id");
        this.title = this.getBody().has("title") ? Optional.of(this.getBody().getString("title")) : Optional.empty();
        this.id = this.getBody().getString("@id");
        this.url = this.getBody().getString("url");
        this.username = this.getBody().getString("username");
        this.status = PlayerStatus.getEnum(this.getBody().getString("status"));
        this.title = this.getBody().has("title") ? Optional.of(this.getBody().getString("title")) : Optional.empty();
        this.avatar = this.getBody().has("avatar") ? Optional.of(this.getBody().getString("avatar")) : Optional.empty();
        this.location = this.getBody().has("location") ? Optional.of(this.getBody().getString("location")) : Optional.empty();
        this.country = this.getBody().getString("country");
        this.joined = new Date(this.getBody().getLong("joined"));
        this.lastOnline = new Date(this.getBody().getLong("last_online"));
        this.followers = this.getBody().getInt("followers");
        this.isStreamer = this.getBody().getBoolean("is_streamer");
        this.twitchUrl = this.getBody().has("twitch_url") ? Optional.of(this.getBody().getString("twitch_url")) : Optional.empty();
        this.fideRating = this.getBody().has("fide") ? Optional.of(this.getBody().getInt("fide")) : Optional.empty();
    }

    @Override
    public String toString() {
        return "Class Name:" + "[ " + this.getClass().getSimpleName() + " ]" + "\n" +
                "Body: " + this.getBody().toString() + "\n";
    }

    public static class DataPlayerResponseBuilder {

        DataPlayerResponse response;

        private DataPlayerResponseBuilder() {
            response = new DataPlayerResponse();
        }

        public DataPlayerResponseBuilder setBody(String body) {
            this.response.setBody(body);
            return this;
        }

        public DataPlayerResponseBuilder setHTTPCode(int httpCode) {
            this.response.setHTTPCode(httpCode);
            return this;
        }

        public DataPlayerResponseBuilder setHeaders(Map<String, String> headers) {
            this.response.setHeaders(headers);
            return this;
        }

        public DataPlayerResponseBuilder setErrorMessage(String errorMessage) {
            this.response.setErrorMessage(errorMessage);
            return this;
        }

        public DataPlayerResponseBuilder setTypeRequest(TypeRequest typeRequest) {
            this.response.setTypeRequest(typeRequest);
            return this;
        }

        public DataPlayerResponse build() {
            this.response.load();
            return this.response;
        }
    }
}



