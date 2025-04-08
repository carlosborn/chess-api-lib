package org.ceborn.http.impl;

import org.ceborn.helpers.HelperDate;
import org.ceborn.http.Response;
import org.ceborn.http.TypeRequest;

import java.util.Map;
import java.util.Optional;

public class GamesFinishedRequest extends AbstractRequest {

    public GamesFinishedRequest(String player) {
        String monthPar = String.valueOf(HelperDate.getMonth());
        if (HelperDate.getMonth() < 10) {
            monthPar = "0" + HelperDate.getMonth();
        }

        this.addPathParameter("player", player);
        this.addPathParameter("games", String.valueOf(HelperDate.getYear()));
        this.addPathParameter(monthPar, "");
        this.setTypeRequest(TypeRequest.GET);
    }

    public GamesFinishedRequest(String player, int year, int month) {
        String monthPar = String.valueOf(month);
        if (month < 10) {
            monthPar = "0" + month;
        }

        this.addPathParameter("player", player);
        this.addPathParameter("games", "");
        this.addPathParameter(String.valueOf(year), monthPar);
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
        return GamesFinishedResponse.newBuilder()
                .setBody(response)
                .setHTTPCode(httpCode)
                .setHeaders(headers)
                .setErrorMessage(errorMessage)
                .setTypeRequest(this.getTypeRequest().isPresent() ? this.getTypeRequest().get() : null)
                .build();
    }
}
