package org.ceborn.http.impl.responses;

import lombok.Getter;
import org.ceborn.builders.TitlesPlayersResponseBuilder;

import java.util.ArrayList;
import java.util.List;

@Getter
public class TitlesPlayersResponse extends AbstractResponse<TitlesPlayersResponse> {

    private final List<String> players = new ArrayList<>();

    private TitlesPlayersResponse() {
    }

    public static TitlesPlayersResponseBuilder newBuilder() {
        return new TitlesPlayersResponseBuilder(new TitlesPlayersResponse());
    }

    public TitlesPlayersResponse load() {
        if (this.getErrorMessage().isPresent()) {
            return this;
        }

        for (Object o : this.getBody().getJSONArray("players").toList()) {
            players.add((String) o);
        }
        return this;
    }
}
