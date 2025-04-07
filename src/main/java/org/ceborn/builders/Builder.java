package org.ceborn.builders;

import org.ceborn.http.TypeRequest;

import java.util.Map;

public interface Builder {

    Builder setBody(String body);

    Builder setHTTPCode(int httpCode);

    Builder setHeaders(Map<String, String> headers);

    Builder setErrorMessage(String errorMessage);

    Builder setTypeRequest(TypeRequest typeRequest);

}
