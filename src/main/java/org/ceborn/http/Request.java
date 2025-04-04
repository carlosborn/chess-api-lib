package org.ceborn.http;

import org.json.JSONObject;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

public interface Request {

    String getURL();

    Request addHeader(String key, String value);

    Request setHeaders(Map<String, String> headers);

    String[] getHeaders();

    Request setTypeRequest(TypeRequest typeRequest);

    Optional<TypeRequest> getTypeRequest();

    Request setQueryParameter(String key, String value);

    Request setQueryParameter(String key, double value);

    Request setQueryParameter(String key, int value);

    Request setQueryParameter(String key, boolean value);

    Request setQueryParameter(String key, long value);

    Request setQueryParameter(String key, char value);

    Request setQueryParameter(String key, LocalDateTime value);

    Request setPathParameter(String key, String value);

    Request setPathParameter(String key, double value);

    Request setPathParameter(String key, int value);

    Request setPathParameter(String key, boolean value);

    Request setPathParameter(String key, long value);

    Request setPathParameter(String key, char value);

    Request setPathParameter(String key, LocalDateTime value);

    abstract Optional<String> toJSON();

    abstract Optional<Map<String, Object>> toMap();

    boolean hasBody();

    abstract Response getResponse(String response, int httpCode, Map<String, String> headers, String errorMessage);

}
