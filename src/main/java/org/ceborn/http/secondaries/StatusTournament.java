package org.ceborn.http.secondaries;

import lombok.Getter;

import java.util.Optional;

@Getter
public enum StatusTournament {

    WINNER("winner"),
    ELIMINATED("eliminated"),
    WITHDREW("withdrew"),
    REMOVED("removed");

    private final String description;

    StatusTournament(String description) {
        this.description = description;
    }

    public static Optional<StatusTournament> getEnum(String description) {
        for (StatusTournament statusTournament : StatusTournament.values()) {
            if (statusTournament.getDescription().equals(description)) {
                return Optional.of(statusTournament);
            }
        }
        return Optional.empty();
    }

}
