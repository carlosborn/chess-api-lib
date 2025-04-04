package org.ceborn.http.impl;

import org.ceborn.http.Request;
import org.ceborn.http.TypeRequest;

import java.time.LocalDateTime;
import java.util.*;

public abstract class AbstractRequest implements Request {

    private Map<String, String> headers = new HashMap<>();
    private TypeRequest typeRequest;
    private final Map<String, Object> queryParameters = new HashMap<>();
    private final Map<String, Object> pathParameters = new LinkedHashMap<>();

    public AbstractRequest() {
        this.initHeaders();
    }

    private void initHeaders() {
        this.headers.put("Accept", "application/json");
        this.headers.put("Content-Type", "application/json; charset=utf-8");
    }

    @Override
    public String getURL() {
        return this.mountURL();
    }

    @Override
    public Request addHeader(String key, String value) {
        this.headers.put(key, value);
        return this;
    }

    @Override
    public Request setHeaders(Map<String, String> headers) {
        this.headers = headers;
        return this;
    }

    @Override
    public String[] getHeaders() {
        List<String> headersString = new ArrayList<>();
        for (Map.Entry<String, String> entry : this.headers.entrySet()) {
            headersString.add(entry.getKey());
            headersString.add(entry.getValue());
        }
        return headersString.toArray(new String[0]);
    }

    @Override
    public Optional<TypeRequest> getTypeRequest() {
        return Optional.of(this.typeRequest);
    }

    @Override
    public Request setTypeRequest(TypeRequest typeRequest) {
        this.typeRequest = typeRequest;
        return this;
    }

    @Override
    public Request addQueryParameter(String key, String value) {
        this.queryParameters.put(key, value);
        return this;
    }

    @Override
    public Request addQueryParameter(String key, double value) {
        this.queryParameters.put(key, value);
        return this;
    }

    @Override
    public Request addQueryParameter(String key, int value) {
        this.queryParameters.put(key, value);
        return this;
    }

    @Override
    public Request addQueryParameter(String key, boolean value) {
        this.queryParameters.put(key, value);
        return this;
    }

    @Override
    public Request addQueryParameter(String key, long value) {
        this.queryParameters.put(key, value);
        return this;
    }

    @Override
    public Request addQueryParameter(String key, char value) {
        this.queryParameters.put(key, value);
        return this;
    }

    @Override
    public Request addQueryParameter(String key, LocalDateTime value) {
        this.queryParameters.put(key, value);
        return this;
    }

    @Override
    public Request addPathParameter(String key, String value) {
        this.pathParameters.put(key, value);
        return this;
    }

    @Override
    public Request addPathParameter(String key, double value) {
        this.pathParameters.put(key, value);
        return this;
    }

    @Override
    public Request addPathParameter(String key, int value) {
        this.pathParameters.put(key, value);
        return this;
    }

    @Override
    public Request addPathParameter(String key, boolean value) {
        this.pathParameters.put(key, value);
        return this;
    }

    @Override
    public Request addPathParameter(String key, long value) {
        this.pathParameters.put(key, value);
        return this;
    }

    @Override
    public Request addPathParameter(String key, char value) {
        this.pathParameters.put(key, value);
        return this;
    }

    @Override
    public Request addPathParameter(String key, LocalDateTime value) {
        this.pathParameters.put(key, value);
        return this;
    }

    private String mountURL() {
        String url = "https://api.chess.com/pub";
        return url + this.mountPathParameters() + this.mountQueryParameters();
    }

    private String mountPathParameters() {
        StringBuilder url = new StringBuilder();
        for (Map.Entry<String, Object> entry : this.pathParameters.entrySet()) {
            url.append("/").append(entry.getKey()).append("/").append(entry.getValue());
        }
        return url.toString();
    }

    private String mountQueryParameters() {
        StringBuilder url = new StringBuilder();
        int first = 0;
        for (Map.Entry<String, Object> entry : this.queryParameters.entrySet()) {
            if (first == 0) {
                url.append("?");
                first++;
            } else {
                url.append("&");
            }

            url.append(entry.getKey()).append("=").append(entry.getValue());
        }
        return url.toString();
    }

}
