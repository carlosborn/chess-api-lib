package org.ceborn.http.impl;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum GameResultCode {

    WIN("win", "Win"),
    CHECKMATED("checkmated", "Checkmated"),
    AGREED("agreed", "Draw agreed"),
    REPETITION("repetition", "Draw by repetition"),
    TIMEOUT("timeout", "Timeout"),
    RESIGNED("resigned", "Resigned"),
    STALEMATE("stalemate", "Stalemate"),
    LOSE("lose", "Lose"),
    INSUFFICIENT("insufficient", "Insufficient material"),
    FIFTY_MOVE("50move", "Draw by 50-move rule"),
    ABANDONED("abandoned", "Abandoned"),
    KING_OF_THE_HILL("kingofthehill", "Opponent king reached the hill"),
    THREE_CHECK("threecheck", "Checked for the 3rd time"),
    TIME_VS_INSUFFICIENT("timevsinsufficient", "Draw by timeout vs insufficient material"),
    BUG_HOUSE_PARTNER_LOSE("bughousepartnerlose", "Bughouse partner lost");

    private final String code;
    private final String description;

    public static GameResultCode getEnumByCode(String code) {
        for (GameResultCode game : GameResultCode.values()) {
            if (game.getCode().equals(code)) {
                return game;
            }
        }
        return null;
    }

}
