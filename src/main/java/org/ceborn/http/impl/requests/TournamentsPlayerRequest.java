package org.ceborn.http.impl.requests;

import org.ceborn.http.Response;
import org.ceborn.http.TypeRequest;
import org.ceborn.http.impl.responses.TournamentsPlayerResponse;

import java.util.Map;
import java.util.Optional;

public class TournamentsPlayerRequest extends AbstractRequest {

    public TournamentsPlayerRequest(String player) {
        this.addPathParameter("player", player);
        this.addPathParameter("tournaments", "");
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
        return TournamentsPlayerResponse.newBuilder()
                .setBody(response)
                .setHTTPCode(httpCode)
                .setHeaders(headers)
                .setErrorMessage(errorMessage)
                .setTypeRequest(this.getTypeRequest().isPresent() ? this.getTypeRequest().get() : null)
                .build();
    }
}
