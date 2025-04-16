package org.ceborn.http.secondaries;

import lombok.Getter;
import org.ceborn.http.impl.GameResultCode;
import org.json.JSONObject;

import java.util.Date;
import java.util.Optional;


public class ClubMatch {

    @Getter
    private final String name;

    @Getter
    private final String id;

    @Getter
    private final String opponent;

    @Getter
    private final String timeClass;

    private final Date startTime;
    private final GameResultCode result;

    public ClubMatch(JSONObject json) {
        this.name = json.getString("name");
        this.id = json.getString("@id");
        this.opponent = json.getString("opponent");
        this.result = json.has("result") ? GameResultCode.getEnumByCode(json.getString("result")) : null;
        this.startTime = json.has("start_time") ? new Date(json.getLong("start_time") * 1000) : null;
        this.timeClass = json.getString("time_class");
    }

    public Optional<Date> getStartTime() {
        return Optional.ofNullable(this.startTime);
    }

    public Optional<GameResultCode> getResult() {
        return Optional.ofNullable(this.result);
    }

}
