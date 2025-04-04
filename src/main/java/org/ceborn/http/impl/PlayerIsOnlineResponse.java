package org.ceborn.http.impl;

import lombok.Getter;
import org.ceborn.http.TypeRequest;

import java.util.Map;

@Getter
public class PlayerIsOnlineResponse extends AbstractResponse {

    private boolean online;

    private PlayerIsOnlineResponse() {
    }

    public static PlayerIsOnlineResponseBuilder newBuilder() {
        return new PlayerIsOnlineResponseBuilder();
    }

    private void load() {
        this.online = this.getBody().getBoolean("online");
    }

    public static class PlayerIsOnlineResponseBuilder {

        PlayerIsOnlineResponse response;

        private PlayerIsOnlineResponseBuilder() {
            response = new PlayerIsOnlineResponse();
        }

        public PlayerIsOnlineResponse.PlayerIsOnlineResponseBuilder setBody(String body) {
            this.response.setBody(body);
            return this;
        }

        public PlayerIsOnlineResponse.PlayerIsOnlineResponseBuilder setHTTPCode(int httpCode) {
            this.response.setHTTPCode(httpCode);
            return this;
        }

        public PlayerIsOnlineResponse.PlayerIsOnlineResponseBuilder setHeaders(Map<String, String> headers) {
            this.response.setHeaders(headers);
            return this;
        }

        public PlayerIsOnlineResponse.PlayerIsOnlineResponseBuilder setErrorMessage(String errorMessage) {
            this.response.setErrorMessage(errorMessage);
            return this;
        }

        public PlayerIsOnlineResponse.PlayerIsOnlineResponseBuilder setTypeRequest(TypeRequest typeRequest) {
            this.response.setTypeRequest(typeRequest);
            return this;
        }

        public PlayerIsOnlineResponse build() {
            this.response.load();
            return this.response;
        }
    }
}
