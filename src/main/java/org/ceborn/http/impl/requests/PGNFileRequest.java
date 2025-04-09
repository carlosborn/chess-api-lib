package org.ceborn.http.impl.requests;

import org.ceborn.helpers.HelperDate;
import org.ceborn.http.Response;
import org.ceborn.http.TypeRequest;
import org.ceborn.http.impl.responses.PGNFileResponse;

import java.io.File;
import java.util.Map;
import java.util.Optional;

public class PGNFileRequest extends AbstractRequest {

    private final String path;

    public PGNFileRequest(String player, String path, int year, int month) {
        String monthPar = String.valueOf(month);
        if (HelperDate.getMonth() < 10) {
            monthPar = "0" + month;
        }

        this.addPathParameter("player", player);
        this.addPathParameter("games", String.valueOf(year));
        this.addPathParameter(monthPar, "pgn");
        this.setTypeRequest(TypeRequest.GET);

        if(!path.endsWith(File.separator)){
            path += File.separator;
        }
        this.path = path;
    }

    public PGNFileRequest(String player, String path) {
        String monthPar = String.valueOf(HelperDate.getMonth());
        if (HelperDate.getMonth() < 10) {
            monthPar = "0" + HelperDate.getMonth();
        }

        this.addPathParameter("player", player);
        this.addPathParameter("games", String.valueOf(HelperDate.getYear()));
        this.addPathParameter(monthPar, "pgn");
        this.setTypeRequest(TypeRequest.GET);

        if(!path.endsWith(File.separator)){
            path += File.separator;
        }
        this.path = path;
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
        return PGNFileResponse.newBuilder()
                .setPath(this.path)
                .setBody(response)
                .setHTTPCode(httpCode)
                .setHeaders(headers)
                .setErrorMessage(errorMessage)
                .build();
    }
}
