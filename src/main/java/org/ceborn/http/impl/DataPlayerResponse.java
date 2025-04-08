package org.ceborn.http.impl;

import lombok.Getter;
import org.ceborn.builders.DataPlayerResponseBuilder;

import java.util.Date;
import java.util.Optional;

public class DataPlayerResponse extends AbstractResponse<DataPlayerResponse> {

    @Getter
    private Long playerId;
    @Getter
    private String id;
    @Getter
    private String url;
    @Getter
    private String username;
    @Getter
    private int followers;
    @Getter
    private String country;
    @Getter
    private Date lastOnline;
    @Getter
    private Date joined;
    @Getter
    private PlayerStatus status;

    private String title;
    private String name;
    private String avatar;
    private String location;
    private boolean isStreamer;
    private String twitchUrl;
    private Integer fideRating;

    public Optional<String> getTitle() {
        return this.title == null ? Optional.empty() : Optional.of(this.title);
    }

    public Optional<String> getName() {
        return this.name == null ? Optional.empty() : Optional.of(this.name);
    }

    public Optional<String> getAvatar() {
        return this.avatar == null ? Optional.empty() : Optional.of(this.avatar);
    }

    public Optional<String> getLocation() {
        return this.location == null ? Optional.empty() : Optional.of(this.location);
    }

    public boolean isStreamer() {
        return isStreamer;
    }

    public Optional<String> getTwitchUrl() {
        return this.twitchUrl == null ? Optional.empty() : Optional.of(this.twitchUrl);
    }

    public Optional<Integer> getFideRating() {
        return this.fideRating == null ? Optional.empty() : Optional.of(this.fideRating);
    }

    private DataPlayerResponse() {
    }

    public static DataPlayerResponseBuilder newBuilder() {
        return new DataPlayerResponseBuilder(new DataPlayerResponse());
    }

    public DataPlayerResponse load() {
        if (this.getErrorMessage().isPresent()) {
            return this;
        }

        this.playerId = this.getBody().getLong("player_id");
        this.title = this.getBody().has("title") ? this.getBody().getString("title") : null;
        this.id = this.getBody().getString("@id");
        this.url = this.getBody().getString("url");
        this.username = this.getBody().getString("username");
        this.status = PlayerStatus.getEnum(this.getBody().getString("status"));
        this.name = this.getBody().has("name") ? this.getBody().getString("name") : null;
        this.avatar = this.getBody().has("avatar") ? this.getBody().getString("avatar") : null;
        this.location = this.getBody().has("location") ? this.getBody().getString("location") : null;
        this.country = this.getBody().getString("country");
        this.joined = new Date(this.getBody().getLong("joined"));
        this.lastOnline = new Date(this.getBody().getLong("last_online"));
        this.followers = this.getBody().getInt("followers");
        this.isStreamer = this.getBody().getBoolean("is_streamer");
        this.twitchUrl = this.getBody().has("twitch_url") ? this.getBody().getString("twitch_url") : null;
        this.fideRating = this.getBody().has("fide") ? this.getBody().getInt("fide") : null;
        return this;
    }

    @Override
    public String toString() {
        return "Class Name:" + "[ " + this.getClass().getSimpleName() + " ]" + "\n" +
                "Body: " + this.getBody().toString() + "\n";
    }
}



