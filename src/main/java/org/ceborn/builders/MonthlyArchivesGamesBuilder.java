package org.ceborn.builders;

import org.ceborn.http.impl.MonthlyArchivesGamesResponse;

public class MonthlyArchivesGamesBuilder extends AbstractBuilder<MonthlyArchivesGamesResponse> {

    public MonthlyArchivesGamesBuilder(MonthlyArchivesGamesResponse monthlyArchivesGamesResponse) {
        super(monthlyArchivesGamesResponse);
    }

    @Override
    public MonthlyArchivesGamesResponse build() {
        return this.getResponse().load();
    }
}
