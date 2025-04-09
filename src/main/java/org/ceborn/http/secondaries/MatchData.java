package org.ceborn.http.secondaries;

import lombok.Getter;
import org.json.JSONObject;

import java.util.Optional;

public class MatchData {

    @Getter
    private final String name;

    @Getter
    private final String url;

    @Getter
    private final String id;

    private final String club;

    private final String board;


    private MatchResultData results;

    public MatchData(JSONObject json) {
        this.name = json.getString("name");
        this.url = json.getString("url");
        this.id = json.getString("@id");
        this.club = json.has("club") ? json.getString("club") : null;
        this.board = json.has("board") ? json.getString("board") : null;

        if (json.has("results")) {
            this.results = new MatchResultData(json.getJSONObject("results"));
        }
    }

    public Optional<MatchResultData> getResults() {
        return Optional.ofNullable(this.results);
    }

    public Optional<String> getClub() {
        return Optional.ofNullable(this.club);
    }

    public Optional<String> getBoard() {
        return Optional.ofNullable(this.board);
    }

}
