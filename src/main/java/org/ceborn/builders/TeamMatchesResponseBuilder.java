package org.ceborn.builders;

import org.ceborn.http.impl.TeamMatchesResponse;

public class TeamMatchesResponseBuilder extends AbstractBuilder<TeamMatchesResponse> {

    public TeamMatchesResponseBuilder(TeamMatchesResponse teamMatchesResponse) {
        super(teamMatchesResponse);
    }

    @Override
    public TeamMatchesResponse build() {
        return this.getResponse().load();
    }
}
