package org.ceborn.http.secondaries;

import lombok.Getter;
import org.json.JSONObject;

import java.util.Date;
import java.util.Optional;

@Getter
public class LastDataPlayerStats {

    private final Optional<Date> date;
    private final int rating;
    private final int rd;

    public LastDataPlayerStats(JSONObject json) {
        this.date = json.has("date") ? Optional.of(new Date(json.getLong("date"))) : Optional.empty();
        this.rating = json.has("rating") ? json.getInt("rating") : 0;
        this.rd = json.has("rd") ? json.getInt("rd") : 0;
    }
}
