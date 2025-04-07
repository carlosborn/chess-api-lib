package org.ceborn.http.impl;

import lombok.Getter;
import org.ceborn.http.TypeRequest;
import org.ceborn.http.secondaries.PlayerCurrentGameData;
import org.json.JSONObject;

import java.util.*;

@Getter
public class PlayerCurrentGamesResponse extends AbstractResponse {

    private final List<PlayerCurrentGameData> games = new ArrayList<>();

    private PlayerCurrentGamesResponse() {
    }

    public static PlayerCurrentGamesBuilder newBuilder() {
        return new PlayerCurrentGamesBuilder();
    }

    private void load() {
        if (this.getBody().has("games")) {
            for (int i = 0; i < this.getBody().getJSONArray("games").length(); i++) {
                JSONObject json = this.getBody().getJSONArray("games").getJSONObject(i);
                this.games.add(new PlayerCurrentGameData(json));
            }
        }
    }

    public static class PlayerCurrentGamesBuilder {

        PlayerCurrentGamesResponse response;

        private PlayerCurrentGamesBuilder() {
            response = new PlayerCurrentGamesResponse();
        }

        public PlayerCurrentGamesResponse.PlayerCurrentGamesBuilder setBody(String body) {
            this.response.setBody(body);
            return this;
        }

        public PlayerCurrentGamesResponse.PlayerCurrentGamesBuilder setHTTPCode(int httpCode) {
            this.response.setHTTPCode(httpCode);
            return this;
        }

        public PlayerCurrentGamesResponse.PlayerCurrentGamesBuilder setHeaders(Map<String, String> headers) {
            this.response.setHeaders(headers);
            return this;
        }

        public PlayerCurrentGamesResponse.PlayerCurrentGamesBuilder setErrorMessage(String errorMessage) {
            this.response.setErrorMessage(errorMessage);
            return this;
        }

        public PlayerCurrentGamesResponse.PlayerCurrentGamesBuilder setTypeRequest(TypeRequest typeRequest) {
            this.response.setTypeRequest(typeRequest);
            return this;
        }

        public PlayerCurrentGamesResponse build() {
            this.response.load();
            return this.response;
        }
    }

}
