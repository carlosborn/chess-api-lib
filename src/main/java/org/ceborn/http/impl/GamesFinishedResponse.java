package org.ceborn.http.impl;

import lombok.Getter;
import org.ceborn.builders.GamesFinishedResponseBuilder;
import org.ceborn.http.secondaries.GamesFinishedData;

import java.util.ArrayList;
import java.util.List;

@Getter
public class GamesFinishedResponse extends AbstractResponse<GamesFinishedResponse> {

    private final List<GamesFinishedData> games = new ArrayList<>();


    private GamesFinishedResponse() {
    }

    public static GamesFinishedResponseBuilder newBuilder() {
        return new GamesFinishedResponseBuilder(new GamesFinishedResponse());
    }


    @Override
    public GamesFinishedResponse load() {
        if (this.getErrorMessage().isPresent()) {
            return this;
        }

        for (int i = 0; i < this.getBody().getJSONArray("games").length(); i++) {
            this.games.add(new GamesFinishedData(this.getBody().getJSONArray("games").getJSONObject(i)));
        }

        return this;
    }
}
