package org.ceborn.http.secondaries;

import lombok.Getter;
import org.json.JSONObject;

@Getter
public class PuzzleRushData {

    private final int totalAttempts;
    private final int score;

    public PuzzleRushData(JSONObject json) {
        this.totalAttempts = json.getInt("total_attempts");
        this.score = json.getInt("score");
    }

}
