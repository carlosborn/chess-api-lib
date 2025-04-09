package org.ceborn.builders;

import org.ceborn.http.impl.responses.PlayerCurrentGamesResponse;

public class PlayerCurrentGamesBuilder extends AbstractBuilder<PlayerCurrentGamesResponse> {

    public PlayerCurrentGamesBuilder(PlayerCurrentGamesResponse playerCurrentGamesResponse) {
        super(playerCurrentGamesResponse);
    }

    @Override
    public PlayerCurrentGamesResponse build() {
        return this.getResponse().load();
    }
}
