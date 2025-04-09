package org.ceborn.builders;

import org.ceborn.http.impl.responses.DailyChessToMoveResponse;

public class DailyChessToMoveResponseBuilder extends AbstractBuilder<DailyChessToMoveResponse> {

    public DailyChessToMoveResponseBuilder(DailyChessToMoveResponse dailyChessToMoveResponse) {
        super(dailyChessToMoveResponse);
    }

    @Override
    public DailyChessToMoveResponse build() {
        return this.getResponse().load();
    }
}
