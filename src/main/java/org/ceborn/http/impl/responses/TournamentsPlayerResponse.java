package org.ceborn.http.impl.responses;

import lombok.Getter;
import org.ceborn.builders.TournamentsPlayerResponseBuilder;
import org.ceborn.http.secondaries.TournamentData;
import org.ceborn.http.secondaries.TournamentDataRegistered;
import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

@Getter
public class TournamentsPlayerResponse extends AbstractResponse<TournamentsPlayerResponse> {

    private List<TournamentData> finished;
    private List<TournamentData> inProgress;
    private List<TournamentDataRegistered> registered;

    private TournamentsPlayerResponse() {
    }

    public static TournamentsPlayerResponseBuilder newBuilder() {
        return new TournamentsPlayerResponseBuilder(new TournamentsPlayerResponse());
    }

    @Override
    public TournamentsPlayerResponse load() {
        if (this.getBody().has("finished")) {
            this.finished = this.loadTournamentData(this.getBody().getJSONArray("finished"));
        }

        if (this.getBody().has("in_progress")) {
            this.inProgress = this.loadTournamentData(this.getBody().getJSONArray("in_progress"));
        }

        if (this.getBody().has("registered")) {
            this.registered = this.loadTournamentDataRegistered(this.getBody().getJSONArray("registered"));
        }

        return this;
    }

    private List<TournamentData> loadTournamentData(JSONArray jsonArray) {
        List<TournamentData> list = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            list.add(new TournamentData(jsonArray.getJSONObject(i)));
        }
        return list;
    }

    private List<TournamentDataRegistered> loadTournamentDataRegistered(JSONArray jsonArray) {
        List<TournamentDataRegistered> list = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            list.add(new TournamentDataRegistered(jsonArray.getJSONObject(i)));
        }
        return list;
    }
}
