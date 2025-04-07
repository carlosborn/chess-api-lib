package org.ceborn.http.impl;

import org.ceborn.http.Response;
import org.ceborn.http.TypeRequest;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public abstract class AbstractResponse<T> implements Response {

    private JSONObject body;
    private int httpCode;
    private String errorMessage;
    private Map<String, String> headers = new HashMap<>();
    private TypeRequest typeRequest;

    abstract T load();

    @Override
    public Response setTypeRequest(TypeRequest typeRequest) {
        this.typeRequest = typeRequest;
        return this;
    }

    @Override
    public TypeRequest getTypeRequest() {
        return this.typeRequest;
    }

    @Override
    public Response setBody(String response) {
        this.body = new JSONObject(response);
        return this;
    }

    @Override
    public Response setBody(Map<String, Object> response) {
        this.body = new JSONObject(response);
        return this;
    }

    @Override
    public JSONObject getBody() {
        return this.body;
    }

    @Override
    public Response setHTTPCode(int code) {
        this.httpCode = code;
        return this;
    }

    @Override
    public Response setErrorMessage(String message) {
        this.errorMessage = message;
        return this;
    }

    @Override
    public Response setHeader(String key, String value) {
        this.headers.put(key, value);
        return this;
    }

    @Override
    public Response setHeaders(Map<String, String> headers) {
        this.headers = headers;
        return this;
    }

    @Override
    public int getHTTPCode() {
        return this.httpCode;
    }

    @Override
    public Optional<String> getErrorMessage() {
        return Optional.of(this.errorMessage);
    }

    @Override
    public Map<String, String> getHeaders() {
        return this.headers;
    }
}
