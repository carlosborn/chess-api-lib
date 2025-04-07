package org.ceborn.http.secondaries;

import lombok.Getter;
import org.json.JSONObject;

import java.util.Date;
import java.util.Optional;

public class PlayerCurrentGameData {

    @Getter
    private final String white;

    @Getter
    private final String black;

    @Getter
    private final String url;

    @Getter
    private final String fen;

    @Getter
    private final String pgn;

    @Getter
    private final String turn;

    @Getter
    private final Date moveBy;

    @Getter
    private final Date lastActivity;

    @Getter
    private final Date startTime;

    @Getter
    private final String timeControl;

    @Getter
    private final String timeClass;

    @Getter
    private final String rules;

    // Optionals
    private final String drawOffer;
    private final String tournament;
    private final String match;
    private final Boolean rated;

    public PlayerCurrentGameData(JSONObject json) {
        this.white = json.getString("white");
        this.black = json.getString("black");
        this.url = json.getString("url");
        this.fen = json.getString("fen");
        this.pgn = json.getString("pgn");
        this.turn = json.getString("turn");
        this.moveBy = new Date(json.getLong("move_by") * 1000);
        this.drawOffer = json.has("draw_offer") ? json.getString("draw_offer") : null;
        this.lastActivity = new Date(json.getLong("last_activity") * 1000);
        this.startTime = new Date(json.getLong("start_time") * 1000);
        this.timeControl = json.getString("time_control");
        this.timeClass = json.getString("time_class");
        this.rules = json.getString("rules");
        this.tournament = json.has("tournament") ? json.getString("tournament") : null;
        this.match = json.has("match") ? json.getString("match") : null;
        this.rated = json.has("rated") ? json.getBoolean("rated") : null;
    }

    public Optional<String> getDrawOffer() {
        return Optional.ofNullable(this.drawOffer);
    }

    public Optional<String> getTournament() {
        return Optional.ofNullable(this.tournament);
    }

    public Optional<String> getMatch() {
        return Optional.ofNullable(this.match);
    }

    public Optional<Boolean> getRated() {
        return Optional.ofNullable(this.rated);
    }
}
