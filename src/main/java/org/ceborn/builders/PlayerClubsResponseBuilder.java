package org.ceborn.builders;

import org.ceborn.http.impl.PlayerClubsResponse;

public class PlayerClubsResponseBuilder extends AbstractBuilder<PlayerClubsResponse> {

    public PlayerClubsResponseBuilder(PlayerClubsResponse playerClubsResponse) {
        super(playerClubsResponse);
    }

    @Override
    public PlayerClubsResponse build() {
        return this.getResponse().load();
    }
}
