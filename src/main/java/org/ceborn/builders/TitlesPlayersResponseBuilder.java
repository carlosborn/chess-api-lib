package org.ceborn.builders;

import org.ceborn.http.impl.responses.TitlesPlayersResponse;

public class TitlesPlayersResponseBuilder extends AbstractBuilder<TitlesPlayersResponse> {

    public TitlesPlayersResponseBuilder(TitlesPlayersResponse titlesPlayersResponse) {
        super(titlesPlayersResponse);
    }

    @Override
    public TitlesPlayersResponse build() {
        return this.getResponse().load();
    }
}
