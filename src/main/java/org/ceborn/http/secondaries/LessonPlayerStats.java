package org.ceborn.http.secondaries;

import lombok.Getter;
import org.json.JSONObject;

@Getter
public class LessonPlayerStats {

    private final RatingStats highest;
    private final RatingStats lowest;

    public LessonPlayerStats(JSONObject json){
        this.highest = new RatingStats(json.getJSONObject("highest"));
        this.lowest = new RatingStats(json.getJSONObject("lowest"));
    }
}
