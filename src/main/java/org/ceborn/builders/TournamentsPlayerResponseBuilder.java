package org.ceborn.builders;

import org.ceborn.http.impl.TournamentsPlayerResponse;

public class TournamentsPlayerResponseBuilder extends AbstractBuilder<TournamentsPlayerResponse> {

    public TournamentsPlayerResponseBuilder(TournamentsPlayerResponse response) {
        super(response);
    }

    @Override
    public TournamentsPlayerResponse build() {
        return this.getResponse().load();
    }
}
