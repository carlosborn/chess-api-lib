package org.ceborn.builders;

import org.ceborn.http.impl.responses.ClubDataResponse;
import org.ceborn.http.impl.responses.ClubMembersResponse;

public class ClubMembersResponseBuilder extends AbstractBuilder<ClubMembersResponse> {

    public ClubMembersResponseBuilder(ClubMembersResponse response) {
        super(response);
    }

    @Override
    public ClubMembersResponse build() {
        return this.getResponse().load();
    }
}
