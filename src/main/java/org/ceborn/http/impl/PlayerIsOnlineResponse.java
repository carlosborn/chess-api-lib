package org.ceborn.http.impl;

import lombok.Getter;
import org.ceborn.builders.PlayerIsOnlineResponseBuilder;
import org.ceborn.http.TypeRequest;

import java.util.Map;

@Getter
public class PlayerIsOnlineResponse extends AbstractResponse<PlayerIsOnlineResponse> {

    private boolean online;

    private PlayerIsOnlineResponse() {
    }

    public static PlayerIsOnlineResponseBuilder newBuilder() {
        return new PlayerIsOnlineResponseBuilder(new PlayerIsOnlineResponse());
    }

    @Override
    public PlayerIsOnlineResponse load() {
        this.online = this.getBody().getBoolean("online");
        return this;
    }

}
