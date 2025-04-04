package org.ceborn.http.secondaries;

import lombok.Getter;
import org.json.JSONObject;

import java.util.Optional;

@Getter
public class RecordDataPlayerStats {

    private final Optional<Integer> win;
    private final Optional<Integer> loss;
    private final Optional<Integer> draw;
    private final Optional<Integer> timePerMove;
    private final Optional<Double> timeoutPercent;

    public RecordDataPlayerStats(JSONObject json) {
        this.win = json.has("win") ? Optional.of(json.getInt("win")) : Optional.empty();
        this.loss = json.has("loss") ? Optional.of(json.getInt("loss")) : Optional.empty();
        this.draw = json.has("draw") ? Optional.of(json.getInt("draw")) : Optional.empty();
        this.timePerMove = json.has("time_per_move") ? Optional.of(json.getInt("time_per_move")) : Optional.empty();
        this.timeoutPercent = json.has("timeout_percent") ? Optional.of(json.getDouble("timeout_percent")) : Optional.empty();
    }

}
