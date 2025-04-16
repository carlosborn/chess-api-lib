package org.ceborn.http.secondaries;

import lombok.Getter;
import org.json.JSONObject;

import java.util.Date;
import java.util.Optional;

public class GamesFinishedData {

    @Getter
    private final String url;

    @Getter
    private final String fen;

    @Getter
    private final String pgn;

    @Getter
    private final Date endTime;

    @Getter
    private final String timeControl;

    @Getter
    private final String rules;

    @Getter
    private final PlayerGameFinishedData black;

    @Getter
    private final PlayerGameFinishedData white;


    // Optionals
    private final String eco;
    private final String tournament;
    private final String match;
    private final Date startTime;
    private final String timeClass;
    private final String tcn;

    public GamesFinishedData(JSONObject json) {
        this.url = json.getString("url");
        this.fen = json.getString("fen");
        this.pgn = json.getString("pgn");
        this.startTime = json.has("start_time") ? new Date(json.getLong("start_time") * 1000) : null;
        this.endTime = new Date(json.getLong("end_time") * 1000);
        this.timeControl = json.getString("time_control");
        this.rules = json.has("rules") ? json.getString("rules") : null;
        this.eco = json.has("eco") ? json.getString("eco") : null;
        this.tournament = json.has("tournament") ? json.getString("tournament") : null;
        this.match = json.has("match") ? json.getString("match") : null;
        this.white = new PlayerGameFinishedData(json.getJSONObject("white"));
        this.black = new PlayerGameFinishedData(json.getJSONObject("black"));
        this.timeClass = json.has("time_class") ? json.getString("time_class") : null;
        this.tcn = json.has("tcn") ? json.getString("tcn") : null;
    }

    public Optional<String> getEco() {
        return Optional.ofNullable(this.eco);
    }

    public Optional<String> getTournament() {
        return Optional.ofNullable(this.tournament);
    }

    public Optional<String> getMatch() {
        return Optional.ofNullable(this.match);
    }

    public Optional<Date> getStartTime() {
        return Optional.ofNullable(this.startTime);
    }

    public Optional<String> getTimeClass() {
        return Optional.ofNullable(this.timeClass);
    }

    public Optional<String> getTcn() {
        return Optional.ofNullable(this.tcn);
    }

}
