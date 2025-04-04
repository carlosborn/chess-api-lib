package org.ceborn.http.impl;

import lombok.Getter;

import javax.swing.*;

@Getter
public enum PlayerStatus {
    CLOSED("closed"),
    CLOSED_FAIR_PLAY_VIOLATIONS("closed:fair_play_violations"),
    BASIC("basic"),
    PREMIUM("premium"),
    MOD("mod"),
    STAFF("staff");

    private final String name;

    PlayerStatus(String name){
        this.name = name;
    }

    public static PlayerStatus getEnum(String name){
        for(PlayerStatus playerStatus : PlayerStatus.values()){
            if(playerStatus.getName().equals(name)){
                return playerStatus;
            }
        }
        return null;
    }
}
