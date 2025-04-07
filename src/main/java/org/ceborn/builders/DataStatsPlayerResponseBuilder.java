package org.ceborn.builders;

import org.ceborn.http.impl.DataStatsPlayerResponse;

public class DataStatsPlayerResponseBuilder extends AbstractBuilder<DataStatsPlayerResponse> {

    public DataStatsPlayerResponseBuilder(DataStatsPlayerResponse dataStatsPlayerResponse) {
        super(dataStatsPlayerResponse);
    }

    @Override
    public DataStatsPlayerResponse build() {
        return this.getResponse().load();
    }
}
