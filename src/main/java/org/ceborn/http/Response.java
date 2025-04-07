package org.ceborn.http;

import org.ceborn.http.impl.AbstractResponse;
import org.json.JSONObject;

import java.util.Map;
import java.util.Optional;

public interface Response {

    Response setBody(String response);

    Response setBody(Map<String, Object> response);

    JSONObject getBody();

    Response setHTTPCode(int code);

    int getHTTPCode();

    Response setErrorMessage(String message);

    Optional<String> getErrorMessage();

    Response setHeader(String key, String value);

    Response setHeaders(Map<String, String> headers);

    Map<String, String> getHeaders();

    Response setTypeRequest(TypeRequest typeRequest);

    TypeRequest getTypeRequest();
}
