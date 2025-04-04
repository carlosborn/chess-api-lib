package org.ceborn;

import org.ceborn.http.Response;
import org.ceborn.http.communications.HTTPSender;
import org.ceborn.http.impl.DataStatsPlayerRequest;

public class Main {
    public static void main(String[] args) {
        DataStatsPlayerRequest request = new DataStatsPlayerRequest("Gollenzado");
        Response response = HTTPSender.sendHTTPRequest(request);
        System.out.println(response);
    }
}