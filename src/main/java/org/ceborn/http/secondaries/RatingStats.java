package org.ceborn.http.secondaries;

import lombok.Getter;
import org.json.JSONObject;

import java.util.Date;

@Getter
public class RatingStats {

    private final int rating;
    private final Date date;

    public RatingStats(JSONObject json) {
        this.rating = json.getInt("rating");
        this.date = new Date(json.getLong("date"));
    }
}
