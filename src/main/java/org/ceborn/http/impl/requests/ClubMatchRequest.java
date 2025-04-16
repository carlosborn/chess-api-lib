package org.ceborn.http.impl.requests;

import org.ceborn.http.Response;
import org.ceborn.http.TypeRequest;
import org.ceborn.http.impl.responses.ClubMatchResponse;

import java.util.Map;
import java.util.Optional;

public class ClubMatchRequest extends AbstractRequest {

    public ClubMatchRequest(String idUrl) {
        this.addPathParameter("club", idUrl);
        this.addPathParameter("matches", "");
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
        return ClubMatchResponse.newBuilder()
                .setBody(response)
                .setHTTPCode(httpCode)
                .setHeaders(headers)
                .setErrorMessage(errorMessage)
                .build();
    }
}
