package org.ceborn.http.secondaries;

import lombok.Getter;
import org.json.JSONObject;

import java.util.Optional;

@Getter
public class TournamentDataPlayersStats {

    private final Optional<Integer> count;
    private final Optional<Integer> withdraw;
    private final Optional<Integer> points;
    private final Optional<Integer> highestFinish;

    public TournamentDataPlayersStats(JSONObject json) {
        this.count = json.has("count") ? Optional.of(json.getInt("count")) : Optional.empty();
        this.withdraw = json.has("withdraw") ? Optional.of(json.getInt("withdraw")) : Optional.empty();
        this.points = json.has("points") ? Optional.of(json.getInt("points")) : Optional.empty();
        this.highestFinish = json.has("win") ? Optional.of(json.getInt("highest_finish")) : Optional.empty();
    }

}
