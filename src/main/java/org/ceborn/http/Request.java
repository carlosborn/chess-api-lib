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

    Request addQueryParameter(String key, String value);

    Request addQueryParameter(String key, double value);

    Request addQueryParameter(String key, int value);

    Request addQueryParameter(String key, boolean value);

    Request addQueryParameter(String key, long value);

    Request addQueryParameter(String key, char value);

    Request addQueryParameter(String key, LocalDateTime value);

    Request addPathParameter(String key, String value);

    Request addPathParameter(String key, double value);

    Request addPathParameter(String key, int value);

    Request addPathParameter(String key, boolean value);

    Request addPathParameter(String key, long value);

    Request addPathParameter(String key, char value);

    Request addPathParameter(String key, LocalDateTime value);

    abstract Optional<String> toJSON();

    abstract Optional<Map<String, Object>> toMap();

    boolean hasBody();

    abstract Response getResponse(String response, int httpCode, Map<String, String> headers, String errorMessage);

}
