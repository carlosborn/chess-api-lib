package org.ceborn.http.secondaries;

import lombok.Getter;
import org.json.JSONObject;

import java.util.Optional;

public class TournamentDataRegistered {

    @Getter
    private final String url;

    @Getter
    private final String id;

    private final StatusTournamentRegistered status;

    public TournamentDataRegistered(JSONObject json) {
        this.url = json.getString("url");
        this.id = json.getString("@id");
        this.status = StatusTournamentRegistered.getEnum(json.getString("status")).isEmpty() ? null : StatusTournamentRegistered.getEnum(json.getString("status")).get();
    }

    public Optional<StatusTournamentRegistered> getStatus() {
        return Optional.ofNullable(this.status);
    }
}
