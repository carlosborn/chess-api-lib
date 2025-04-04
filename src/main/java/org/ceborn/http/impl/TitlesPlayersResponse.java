package org.ceborn.http.impl;

import lombok.Getter;
import org.ceborn.http.TypeRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
public class TitlesPlayersResponse extends AbstractResponse {

    private final List<String> players = new ArrayList<>();

    private TitlesPlayersResponse() {
    }

    public static TitlesPlayersResponse.TitlesPlayersResponseBuilder newBuilder() {
        return new TitlesPlayersResponse.TitlesPlayersResponseBuilder();
    }

    private void load() {
        for (Object o : this.getBody().getJSONArray("players").toList()) {
            players.add((String) o);
        }
    }

    public static class TitlesPlayersResponseBuilder {

        private final TitlesPlayersResponse response;

        private TitlesPlayersResponseBuilder() {
            this.response = new TitlesPlayersResponse();
        }

        public TitlesPlayersResponse.TitlesPlayersResponseBuilder setBody(String body) {
            this.response.setBody(body);
            return this;
        }

        public TitlesPlayersResponse.TitlesPlayersResponseBuilder setHTTPCode(int httpCode) {
            this.response.setHTTPCode(httpCode);
            return this;
        }

        public TitlesPlayersResponse.TitlesPlayersResponseBuilder setHeaders(Map<String, String> headers) {
            this.response.setHeaders(headers);
            return this;
        }

        public TitlesPlayersResponse.TitlesPlayersResponseBuilder setErrorMessage(String errorMessage) {
            this.response.setErrorMessage(errorMessage);
            return this;
        }

        public TitlesPlayersResponse.TitlesPlayersResponseBuilder setTypeRequest(TypeRequest typeRequest) {
            this.response.setTypeRequest(typeRequest);
            return this;
        }

        public TitlesPlayersResponse build() {
            this.response.load();
            return this.response;
        }

    }

}
