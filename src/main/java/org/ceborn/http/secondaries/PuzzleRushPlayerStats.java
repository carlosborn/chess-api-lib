package org.ceborn.http.secondaries;

import org.json.JSONObject;

import java.util.Optional;

public class PuzzleRushPlayerStats {

    private PuzzleRushData daily;
    private PuzzleRushData best;

    public PuzzleRushPlayerStats(JSONObject json) {
        if (json.has("daily")) {
            this.daily = new PuzzleRushData(json.getJSONObject("daily"));
        }
        if (json.has("best")) {
            this.best = new PuzzleRushData(json.getJSONObject("best"));
        }
    }

    public Optional<PuzzleRushData> getDaily() {
        return this.daily == null ? Optional.empty() : Optional.of(this.daily);
    }

    public Optional<PuzzleRushData> getBest() {
        return this.best == null ? Optional.empty() : Optional.of(this.best);
    }
}
