package org.ceborn.http.secondaries;

import lombok.Getter;
import org.json.JSONObject;

@Getter
public class MatchResultData {

    private final String playedAsWhite;
    private final String playedAsBlack;

    public MatchResultData(JSONObject json) {
        this.playedAsBlack = json.getString("played_as_black");
        this.playedAsWhite = json.getString("played_as_white");
    }

}
