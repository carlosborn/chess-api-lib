package org.ceborn.builders;

import org.ceborn.http.impl.PlayerCurrentGamesResponse;

public class PlayerCurrentGamesBuilder extends AbstractBuilder<PlayerCurrentGamesResponse> {

    public PlayerCurrentGamesBuilder(PlayerCurrentGamesResponse playerCurrentGamesResponse) {
        super(playerCurrentGamesResponse);
    }

    @Override
    public PlayerCurrentGamesResponse build() {
        return this.getResponse().load();
    }
}
