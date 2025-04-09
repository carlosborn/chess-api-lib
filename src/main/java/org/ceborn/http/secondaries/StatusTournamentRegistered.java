package org.ceborn.http.secondaries;

import lombok.Getter;

import java.util.Optional;

@Getter
public enum StatusTournamentRegistered {

    INVITED("invited"),
    REGISTERED("registered");

    private final String description;

    StatusTournamentRegistered(String description) {
        this.description = description;
    }

    public static Optional<StatusTournamentRegistered> getEnum(String description) {
        for (StatusTournamentRegistered statusTournament : StatusTournamentRegistered.values()) {
            if (statusTournament.getDescription().equals(description)) {
                return Optional.of(statusTournament);
            }
        }
        return Optional.empty();
    }

}
