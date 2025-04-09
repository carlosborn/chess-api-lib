package org.ceborn.http.impl.responses;

import lombok.Getter;
import org.ceborn.builders.TeamMatchesResponseBuilder;
import org.ceborn.http.secondaries.MatchData;
import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

@Getter
public class TeamMatchesResponse extends AbstractResponse<TeamMatchesResponse> {

    private List<MatchData> finished;
    private List<MatchData> inProgress;
    private List<MatchData> registered;

    private TeamMatchesResponse() {
    }

    public static TeamMatchesResponseBuilder newBuilder() {
        return new TeamMatchesResponseBuilder(new TeamMatchesResponse());
    }

    @Override
    public TeamMatchesResponse load() {
        if (this.getBody().has("finished")) {
            this.finished = this.loadMatchData(this.getBody().getJSONArray("finished"));
        }

        if (this.getBody().has("in_progress")) {
            this.inProgress = this.loadMatchData(this.getBody().getJSONArray("in_progress"));
        }

        if (this.getBody().has("registered")) {
            this.registered = this.loadMatchData(this.getBody().getJSONArray("registered"));
        }

        return this;
    }

    private List<MatchData> loadMatchData(JSONArray jsonArray) {
        List<MatchData> list = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            list.add(new MatchData(jsonArray.getJSONObject(i)));
        }
        return list;
    }
}
