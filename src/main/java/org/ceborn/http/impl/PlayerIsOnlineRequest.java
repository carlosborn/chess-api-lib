package org.ceborn.http.impl;

import org.ceborn.http.Response;
import org.ceborn.http.TypeRequest;

import java.util.Map;
import java.util.Optional;

public class PlayerIsOnlineRequest extends AbstractRequest {

    public PlayerIsOnlineRequest(String player) {
        this.addPathParameter("player", player);
        this.addPathParameter("is-online", "");
        this.setTypeRequest(TypeRequest.GET);
    }

    @Override
    public Optional<String> toJSON() {
        return Optional.empty();
    }

    @Override
    public Optional<Map<String, Object>> toMap() {
        return Optional.empty();
    }

    @Override
    public boolean hasBody() {
        return false;
    }

    @Override
    public Response getResponse(String response, int httpCode, Map<String, String> headers, String errorMessage) {
        return PlayerIsOnlineResponse.newBuilder()
                .setBody(response)
                .setHTTPCode(httpCode)
                .setHeaders(headers)
                .setErrorMessage(errorMessage)
                .build();
    }
}
