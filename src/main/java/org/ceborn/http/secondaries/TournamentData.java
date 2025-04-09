package org.ceborn.http.secondaries;

import lombok.Getter;
import org.json.JSONObject;

import java.util.Optional;

public class TournamentData {

    @Getter
    private final String url;

    @Getter
    private final String id;

    @Getter
    private final Integer wins;

    @Getter
    private final Integer losses;

    @Getter
    private final Integer draws;

    @Getter
    private final Integer totalPlayers;

    private final StatusTournament status;
    private final Integer pointsAwarded;
    private final Integer placement;

    public TournamentData(JSONObject json) {
        this.url = json.getString("url");
        this.id = json.getString("@id");
        this.wins = json.getInt("wins");
        this.losses = json.getInt("losses");
        this.draws = json.getInt("draws");
        this.pointsAwarded = json.has("points_awarded") ? json.getInt("points_awarded") : null;
        this.placement = json.has("placement") ? json.getInt("placement") : null;
        this.status = StatusTournament.getEnum(json.getString("status")).isEmpty() ? null : StatusTournament.getEnum(json.getString("status")).get();
        this.totalPlayers = json.getInt("total_players");
    }

    public Optional<StatusTournament> getStatus() {
        return Optional.ofNullable(this.status);
    }

    public Optional<Integer> getPointsAwarded() {
        return Optional.ofNullable(this.pointsAwarded);
    }

    public Optional<Integer> getPlacement() {
        return Optional.ofNullable(this.placement);
    }

}
