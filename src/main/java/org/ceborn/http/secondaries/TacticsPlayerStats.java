package org.ceborn.http.secondaries;

import lombok.Getter;
import org.json.JSONObject;

@Getter
public class TacticsPlayerStats {

    private final RatingStats highest;
    private final RatingStats lowest;

    public TacticsPlayerStats(JSONObject json){
        this.highest = new RatingStats(json.getJSONObject("highest"));
        this.lowest = new RatingStats(json.getJSONObject("lowest"));
    }
}
