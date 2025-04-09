package org.ceborn.http.impl;

import lombok.Getter;

@Getter
public enum VisibilityClub {

    PUBLIC("public"),
    PRIVATE("private");

    private final String description;

    VisibilityClub(String description) {
        this.description = description;
    }

    public static VisibilityClub getEnum(String name) {
        for (VisibilityClub visibilityClub : VisibilityClub.values()) {
            if (visibilityClub.getDescription().equals(name)) {
                return visibilityClub;
            }
        }
        return null;
    }

}
