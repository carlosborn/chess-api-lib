package org.ceborn.builders;

import org.ceborn.http.impl.DataPlayerResponse;

public class DataPlayerResponseBuilder extends AbstractBuilder<DataPlayerResponse> {

    public DataPlayerResponseBuilder(DataPlayerResponse dataPlayerResponse) {
        super(dataPlayerResponse);
    }

    @Override
    public DataPlayerResponse build() {
        return ((DataPlayerResponse) this.getResponse()).load();
    }
}
