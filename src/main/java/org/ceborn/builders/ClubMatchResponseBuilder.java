package org.ceborn.builders;

import org.ceborn.http.impl.responses.ClubMatchResponse;

public class ClubMatchResponseBuilder extends AbstractBuilder<ClubMatchResponse> {

    public ClubMatchResponseBuilder(ClubMatchResponse response) {
        super(response);
    }

    @Override
    public ClubMatchResponse build() {
        return this.getResponse().load();
    }
}
