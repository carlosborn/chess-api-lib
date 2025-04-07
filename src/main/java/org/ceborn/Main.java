package org.ceborn;

import org.ceborn.http.Request;
import org.ceborn.http.Response;
import org.ceborn.http.communications.HTTPSender;
import org.ceborn.http.impl.DataStatsPlayerRequest;
import org.ceborn.http.impl.PlayerCurrentGamesRequest;
import org.ceborn.http.impl.PlayerIsOnlineRequest;

public class Main {
    public static void main(String[] args) {
        Request request = new PlayerCurrentGamesRequest("erik");
        Response response = HTTPSender.sendHTTPRequest(request);
        System.out.println(response);
    }
}