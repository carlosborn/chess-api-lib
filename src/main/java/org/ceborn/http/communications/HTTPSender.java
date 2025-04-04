package org.ceborn.http.communications;

import org.ceborn.exceptions.TypeRequestNotFoundException;
import org.ceborn.http.Request;
import org.ceborn.http.Response;
import org.ceborn.http.TypeRequest;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HTTPSender {

    public static Response sendHTTPRequest(Request request) {
        HttpClient client = HttpClient
                .newBuilder()
                .followRedirects(HttpClient.Redirect.ALWAYS)
                .build();

        HttpResponse<String> response;
        try {
            HttpRequest httpRequest = getHttpRequest(request);
            response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException | URISyntaxException e) {
            return request.getResponse(null, 0, null, e.getMessage());
        }

        Map<String, String> headers = getHeaders(response.headers().map());
        int httpCode = response.statusCode();
        return request.getResponse(response.body(), httpCode, headers, null);
    }

    private static HttpRequest getHttpRequest(Request request) throws URISyntaxException {
        if (request.getTypeRequest().isEmpty()) {
            throw new TypeRequestNotFoundException("Type Request on " + request.getClass().getSimpleName() + " not found.");
        }

        TypeRequest typeRequest = request.getTypeRequest().get();
        HttpRequest.BodyPublisher bodyPublisher = HttpRequest.BodyPublishers.noBody();
        if (request.hasBody()) {
            bodyPublisher = HttpRequest.BodyPublishers.ofString(request.toJSON().toString(), StandardCharsets.UTF_8);
        }

        return HttpRequest.newBuilder()
                .uri(new URI(request.getURL()))
                .headers(request.getHeaders())
                .method(typeRequest.name(), bodyPublisher)
                .build();
    }

    private static Map<String, String> getHeaders(Map<String, List<String>> headers) {
        Map<String, String> headersResponse = new HashMap<>();
        for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
            String key = entry.getKey();
            StringBuilder value = new StringBuilder();
            for (String valueEntry : entry.getValue()) {
                value.append(valueEntry).append(";");
            }
            headersResponse.put(key, value.toString());
        }
        return headersResponse;
    }

}
