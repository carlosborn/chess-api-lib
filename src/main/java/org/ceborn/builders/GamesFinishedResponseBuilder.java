package org.ceborn.builders;

import org.ceborn.http.impl.responses.GamesFinishedResponse;

public class GamesFinishedResponseBuilder extends AbstractBuilder<GamesFinishedResponse> {

    public GamesFinishedResponseBuilder(GamesFinishedResponse gamesFinishedResponse) {
        super(gamesFinishedResponse);
    }

    @Override
    public GamesFinishedResponse build() {
        return this.getResponse().load();
    }
}
