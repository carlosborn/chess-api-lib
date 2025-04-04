package org.ceborn;

import org.ceborn.http.Response;
import org.ceborn.http.communications.HTTPSender;
import org.ceborn.http.impl.DataPlayerRequest;
import org.ceborn.http.impl.TitlesAbbreviations;
import org.ceborn.http.impl.TitlesPlayersRequest;

public class Main {
    public static void main(String[] args) {
        TitlesPlayersRequest request = new TitlesPlayersRequest(TitlesAbbreviations.CM);
        Response response = HTTPSender.sendHTTPRequest(request);
        System.out.println(response);
    }
}