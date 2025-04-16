package org.ceborn.http.impl.responses;

import lombok.Getter;
import org.ceborn.builders.ClubMatchResponseBuilder;
import org.ceborn.http.secondaries.ClubMatch;
import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ClubMatchResponse extends AbstractResponse<ClubMatchResponse> {

    private List<ClubMatch> finished;
    private List<ClubMatch> inProgress;
    private List<ClubMatch> registered;

    private ClubMatchResponse() {
    }

    public static ClubMatchResponseBuilder newBuilder() {
        return new ClubMatchResponseBuilder(new ClubMatchResponse());
    }

    @Override
    public ClubMatchResponse load() {
        if (this.getBody().has("finished")) {
            this.finished = this.loadClubMatches(this.getBody().getJSONArray("finished"));
        }

        if (this.getBody().has("in_progress")) {
            this.inProgress = this.loadClubMatches(this.getBody().getJSONArray("in_progress"));
        }

        if (this.getBody().has("registered")) {
            this.registered = this.loadClubMatches(this.getBody().getJSONArray("registered"));
        }

        return this;
    }

    private List<ClubMatch> loadClubMatches(JSONArray jsonArray) {
        List<ClubMatch> clubMatches = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            clubMatches.add(new ClubMatch(jsonArray.getJSONObject(i)));
        }
        return clubMatches;
    }
}
