package org.ceborn.http.impl.responses;

import lombok.Getter;
import org.ceborn.builders.PlayerCurrentGamesBuilder;
import org.ceborn.http.secondaries.PlayerCurrentGameData;
import org.json.JSONObject;

import java.util.*;

@Getter
public class PlayerCurrentGamesResponse extends AbstractResponse<PlayerCurrentGamesResponse> {

    private final List<PlayerCurrentGameData> games = new ArrayList<>();

    private PlayerCurrentGamesResponse() {
    }

    public static PlayerCurrentGamesBuilder newBuilder() {
        return new PlayerCurrentGamesBuilder(new PlayerCurrentGamesResponse());
    }

    @Override
    public PlayerCurrentGamesResponse load() {
        if (this.getErrorMessage().isPresent()) {
            return this;
        }

        if (this.getBody().has("games")) {
            for (int i = 0; i < this.getBody().getJSONArray("games").length(); i++) {
                JSONObject json = this.getBody().getJSONArray("games").getJSONObject(i);
                this.games.add(new PlayerCurrentGameData(json));
            }
        }

        return this;
    }
}
