package org.ceborn.builders;

import org.ceborn.http.impl.responses.ClubDataResponse;

public class ClubDataResponseBuilder extends AbstractBuilder<ClubDataResponse> {

    public ClubDataResponseBuilder(ClubDataResponse response) {
        super(response);
    }

    @Override
    public ClubDataResponse build() {
        return this.getResponse().load();
    }
}
