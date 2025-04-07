package org.ceborn.http.impl;

import lombok.Getter;
import org.ceborn.builders.TitlesPlayersResponseBuilder;
import org.ceborn.http.TypeRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
public class TitlesPlayersResponse extends AbstractResponse<TitlesPlayersResponse> {

    private final List<String> players = new ArrayList<>();

    private TitlesPlayersResponse() {
    }

    public static TitlesPlayersResponseBuilder newBuilder() {
        return new TitlesPlayersResponseBuilder(new TitlesPlayersResponse());
    }

    public TitlesPlayersResponse load() {
        for (Object o : this.getBody().getJSONArray("players").toList()) {
            players.add((String) o);
        }
        return this;
    }
}
