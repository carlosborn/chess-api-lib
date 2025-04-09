package org.ceborn.builders;

import org.ceborn.http.impl.responses.PlayerIsOnlineResponse;

public class PlayerIsOnlineResponseBuilder extends AbstractBuilder<PlayerIsOnlineResponse> {

    public PlayerIsOnlineResponseBuilder(PlayerIsOnlineResponse playerIsOnlineResponse) {
        super(playerIsOnlineResponse);
    }

    @Override
    public PlayerIsOnlineResponse build() {
        return this.getResponse().load();
    }
}
