package org.ceborn.http.impl;

import org.ceborn.builders.DataStatsPlayerResponseBuilder;
import org.ceborn.http.secondaries.*;

import java.util.Optional;

public class DataStatsPlayerResponse extends AbstractResponse<DataStatsPlayerResponse> {

    private ChessRapid chessRapid;
    private ChessDaily chessDaily;
    private Chess960Daily chess960Daily;
    private ChessBlitz chessBlitz;
    private TacticsPlayerStats tactics;
    private LessonsPlayerStats lessons;
    private PuzzleRushPlayerStats puzzleRush;

    private DataStatsPlayerResponse() {
    }

    public static DataStatsPlayerResponseBuilder newBuilder() {
        return new DataStatsPlayerResponseBuilder(new DataStatsPlayerResponse());
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

    public DataStatsPlayerResponse load() {
        if (this.getErrorMessage().isPresent()) {
            return this;
        }

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

        return this;
    }
}
