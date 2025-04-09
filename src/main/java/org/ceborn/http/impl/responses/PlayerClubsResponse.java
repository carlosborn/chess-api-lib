package org.ceborn.http.impl.responses;

import lombok.Getter;
import org.ceborn.builders.PlayerClubsResponseBuilder;
import org.ceborn.http.secondaries.ClubData;

import java.util.ArrayList;
import java.util.List;

@Getter
public class PlayerClubsResponse extends AbstractResponse<PlayerClubsResponse> {

    private final List<ClubData> clubs = new ArrayList<>();

    private PlayerClubsResponse() {
    }

    public static PlayerClubsResponseBuilder newBuilder() {
        return new PlayerClubsResponseBuilder(new PlayerClubsResponse());
    }

    @Override
    public PlayerClubsResponse load() {
        if (this.getBody().has("clubs")) {
            for (int i = 0; i < this.getBody().getJSONArray("clubs").length(); i++) {
                this.clubs.add(new ClubData(this.getBody().getJSONArray("clubs").getJSONObject(i)));
            }
        }

        return this;
    }
}
