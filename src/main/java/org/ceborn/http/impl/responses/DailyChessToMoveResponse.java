package org.ceborn.http.impl.responses;

import lombok.Getter;
import org.ceborn.builders.DailyChessToMoveResponseBuilder;
import org.ceborn.http.secondaries.DailyChessToMoveData;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

@Getter
public class DailyChessToMoveResponse extends AbstractResponse<DailyChessToMoveResponse> {

    private final List<DailyChessToMoveData> games = new ArrayList<>();

    private DailyChessToMoveResponse() {
    }

    public static DailyChessToMoveResponseBuilder newBuilder() {
        return new DailyChessToMoveResponseBuilder(new DailyChessToMoveResponse());
    }

    @Override
    public DailyChessToMoveResponse load() {
        if (this.getErrorMessage().isPresent()) {
            return this;
        }

        if (this.getBody().has("games")) {
            for (int i = 0; i < this.getBody().getJSONArray("games").length(); i++) {
                JSONObject json = this.getBody().getJSONArray("games").getJSONObject(i);
                this.games.add(new DailyChessToMoveData(json));
            }
        }

        return this;
    }
}
