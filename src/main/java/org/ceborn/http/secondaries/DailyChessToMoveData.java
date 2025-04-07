package org.ceborn.http.secondaries;

import lombok.Getter;
import org.json.JSONObject;

import java.util.Date;
import java.util.Optional;


public class DailyChessToMoveData {

    @Getter
    private final String url;

    @Getter
    private final Date moveBy;

    private final Boolean drawOffer;

    @Getter
    private final Date lastActivity;

    public DailyChessToMoveData(JSONObject json){
        this.url = json.getString("url");
        this.moveBy = new Date(json.getLong("move_by") * 1000);
        this.drawOffer = json.has("draw_offer") ? json.getBoolean("draw_offer") : null;
        this.lastActivity = new Date(json.getLong("last_activity") * 1000);
    }

    public Optional<Boolean> getDrawOffer(){
        return Optional.ofNullable(this.drawOffer);
    }
}
