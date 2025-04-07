package org.ceborn.builders;

import org.ceborn.http.Response;
import org.ceborn.http.impl.DailyChessToMoveResponse;
import org.ceborn.http.impl.DataPlayerResponse;

public class DailyChessToMoveResponseBuilder extends AbstractBuilder<DailyChessToMoveResponse> {

    public DailyChessToMoveResponseBuilder(DailyChessToMoveResponse dailyChessToMoveResponse) {
        super(dailyChessToMoveResponse);
    }

    @Override
    public DailyChessToMoveResponse build() {
        return this.getResponse().load();
    }
}
