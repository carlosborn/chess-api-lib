package org.ceborn.builders;

import lombok.Getter;
import org.ceborn.http.Response;
import org.ceborn.http.TypeRequest;

import java.util.Map;

@Getter
public abstract class AbstractBuilder<T extends Response> implements Builder {

    private final T response;

    public AbstractBuilder(T response) {
        this.response = response;
    }

    public abstract T build();

    public AbstractBuilder<T> setBody(String body) {
        this.response.setBody(body);
        return this;
    }

    public AbstractBuilder<T> setHTTPCode(int httpCode) {
        this.response.setHTTPCode(httpCode);
        return this;
    }

    public AbstractBuilder<T> setHeaders(Map<String, String> headers) {
        this.response.setHeaders(headers);
        return this;
    }

    public AbstractBuilder<T> setErrorMessage(String errorMessage) {
        this.response.setErrorMessage(errorMessage);
        return this;
    }

    public AbstractBuilder<T> setTypeRequest(TypeRequest typeRequest) {
        this.response.setTypeRequest(typeRequest);
        return this;
    }

}
