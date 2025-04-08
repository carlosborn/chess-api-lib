package org.ceborn;

import org.ceborn.http.Request;
import org.ceborn.http.Response;
import org.ceborn.http.communications.HTTPSender;
import org.ceborn.http.impl.DailyChessToMoveRequest;
import org.ceborn.http.impl.GamesFinishedRequest;
import org.ceborn.http.impl.MonthlyArchivesGamesRequest;
import org.ceborn.http.impl.PGNFileRequest;

public class Main {
    public static void main(String[] args) {
        Request request = new PGNFileRequest("Gollenzado", "/home/carlos/Downloads/");
        Response response = HTTPSender.sendHTTPRequest(request);
        System.out.println(response);
    }
}