package org.ceborn;

import org.ceborn.http.Request;
import org.ceborn.http.Response;
import org.ceborn.http.communications.HTTPSender;
import org.ceborn.http.impl.*;

public class Main {
    public static void main(String[] args) {
        Request request = new TeamMatchesRequest("erik");
        Response response = HTTPSender.sendHTTPRequest(request);
        System.out.println(response.getBody());
    }
}