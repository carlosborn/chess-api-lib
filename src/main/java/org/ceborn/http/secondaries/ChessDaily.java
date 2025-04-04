package org.ceborn.http.secondaries;

import lombok.Getter;
import org.json.JSONObject;

@Getter
public class ChessDaily {

    private LastDataPlayerStats last;
    private BestDataPlayerStats best;
    private RecordDataPlayerStats record;
    private TournamentDataPlayersStats tournament;

    public ChessDaily(JSONObject json) {
        if (json.has("last")) {
            this.last = new LastDataPlayerStats(json.getJSONObject("last"));
        }

        if (json.has("best")) {
            this.best = new BestDataPlayerStats(json.getJSONObject("best"));
        }

        if (json.has("record")) {
            this.record = new RecordDataPlayerStats(json.getJSONObject("record"));
        }

        if (json.has("tournament")) {
            this.tournament = new TournamentDataPlayersStats(json.getJSONObject("tournament"));
        }
    }

}
