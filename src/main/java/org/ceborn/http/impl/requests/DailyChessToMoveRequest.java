package org.ceborn.http.impl.requests;

import org.ceborn.http.Response;
import org.ceborn.http.TypeRequest;
import org.ceborn.http.impl.responses.DailyChessToMoveResponse;

import java.util.Map;
import java.util.Optional;

public class DailyChessToMoveRequest extends AbstractRequest {

    public DailyChessToMoveRequest(String player) {
        this.addPathParameter("player", player);
        this.addPathParameter("games", "to-move");
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
        return DailyChessToMoveResponse.newBuilder()
                .setBody(response)
                .setHTTPCode(httpCode)
                .setHeaders(headers)
                .setErrorMessage(errorMessage)
                .build();
    }
}
