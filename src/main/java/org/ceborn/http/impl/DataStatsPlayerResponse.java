package org.ceborn.http.impl;

import org.ceborn.http.TypeRequest;
import org.ceborn.http.secondaries.*;

import java.util.Map;
import java.util.Optional;

public class DataStatsPlayerResponse extends AbstractResponse {

    private ChessRapid chessRapid;
    private ChessDaily chessDaily;
    private Chess960Daily chess960Daily;
    private ChessBlitz chessBlitz;
    private TacticsPlayerStats tactics;
    private LessonsPlayerStats lessons;
    private PuzzleRushPlayerStats puzzleRush;

    private DataStatsPlayerResponse() {
    }

    public static DataStatsPlayerResponse.DataStatsPlayerResponseBuilder newBuilder() {
        return new DataStatsPlayerResponse.DataStatsPlayerResponseBuilder();
    }

    public Optional<ChessRapid> getChessRapid() {
        return this.chessRapid == null ? Optional.empty() : Optional.of(this.chessRapid);
    }

    public Optional<ChessDaily> getChessDaily() {
        return this.chessDaily == null ? Optional.empty() : Optional.of(this.chessDaily);
    }

    public Optional<Chess960Daily> getChess960Daily() {
        return this.chess960Daily == null ? Optional.empty() : Optional.of(this.chess960Daily);
    }

    public Optional<ChessBlitz> getChessBlitz() {
        return this.chessBlitz == null ? Optional.empty() : Optional.of(this.chessBlitz);
    }

    public Optional<TacticsPlayerStats> getTactics() {
        return this.tactics == null ? Optional.empty() : Optional.of(this.tactics);
    }

    public Optional<LessonsPlayerStats> getLessons() {
        return this.lessons == null ? Optional.empty() : Optional.of(this.lessons);
    }

    public Optional<PuzzleRushPlayerStats> getPuzzleRush() {
        return this.puzzleRush == null ? Optional.empty() : Optional.of(this.puzzleRush);
    }

    private void load() {
        if (this.getBody().has("chess_rapid")) {
            this.chessRapid = new ChessRapid(this.getBody().getJSONObject("chess_rapid"));
        }

        if (this.getBody().has("chess_daily")) {
            this.chessDaily = new ChessDaily(this.getBody().getJSONObject("chess_daily"));
        }

        if (this.getBody().has("chess960_daily")) {
            this.chess960Daily = new Chess960Daily(this.getBody().getJSONObject("chess960_daily"));
        }

        if (this.getBody().has("chess_blitz")) {
            this.chessBlitz = new ChessBlitz(this.getBody().getJSONObject("chess_blitz"));
        }

        if (this.getBody().has("tactics")) {
            this.tactics = new TacticsPlayerStats(this.getBody().getJSONObject("tactics"));
        }

        if (this.getBody().has("lessons")) {
            this.lessons = new LessonsPlayerStats(this.getBody().getJSONObject("lessons"));
        }

        if (this.getBody().has("puzzle_rush")) {
            this.puzzleRush = new PuzzleRushPlayerStats(this.getBody().getJSONObject("puzzle_rush"));
        }
    }

    public static class DataStatsPlayerResponseBuilder {

        DataStatsPlayerResponse response;

        private DataStatsPlayerResponseBuilder() {
            response = new DataStatsPlayerResponse();
        }

        public DataStatsPlayerResponse.DataStatsPlayerResponseBuilder setBody(String body) {
            this.response.setBody(body);
            return this;
        }

        public DataStatsPlayerResponse.DataStatsPlayerResponseBuilder setHTTPCode(int httpCode) {
            this.response.setHTTPCode(httpCode);
            return this;
        }

        public DataStatsPlayerResponse.DataStatsPlayerResponseBuilder setHeaders(Map<String, String> headers) {
            this.response.setHeaders(headers);
            return this;
        }

        public DataStatsPlayerResponse.DataStatsPlayerResponseBuilder setErrorMessage(String errorMessage) {
            this.response.setErrorMessage(errorMessage);
            return this;
        }

        public DataStatsPlayerResponse.DataStatsPlayerResponseBuilder setTypeRequest(TypeRequest typeRequest) {
            this.response.setTypeRequest(typeRequest);
            return this;
        }

        public DataStatsPlayerResponse build() {
            this.response.load();
            return this.response;
        }
    }

}
