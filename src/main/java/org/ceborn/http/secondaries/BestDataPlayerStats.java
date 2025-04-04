package org.ceborn.http.secondaries;

import lombok.Getter;
import org.json.JSONObject;

import java.util.Date;

@Getter
public class BestDataPlayerStats {

    private final Date date;
    private final int rating;
    private final String game;

    public BestDataPlayerStats(JSONObject json) {
        this.date = new Date(json.getLong("date"));
        this.rating = json.getInt("rating");
        this.game = json.getString("game");
    }

}
