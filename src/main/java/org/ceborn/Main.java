package org.ceborn;

import org.ceborn.http.Response;
import org.ceborn.http.communications.HTTPSender;
import org.ceborn.http.impl.DataPlayerRequest;

public class Main {
    public static void main(String[] args) {
        DataPlayerRequest dataPlayerRequest = new DataPlayerRequest("Gollenzado");
        Response response = HTTPSender.sendHTTPRequest(dataPlayerRequest);
        System.out.println(response.getErrorMessage());
    }
}