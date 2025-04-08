package org.ceborn.http.impl;

import lombok.Getter;
import org.ceborn.builders.MonthlyArchivesGamesBuilder;

import java.util.ArrayList;
import java.util.List;

@Getter
public class MonthlyArchivesGamesResponse extends AbstractResponse<MonthlyArchivesGamesResponse> {

    private final List<String> archives = new ArrayList<>();

    private MonthlyArchivesGamesResponse() {
    }

    public static MonthlyArchivesGamesBuilder newBuilder() {
        return new MonthlyArchivesGamesBuilder(new MonthlyArchivesGamesResponse());
    }

    @Override
    public MonthlyArchivesGamesResponse load() {
        if (this.getErrorMessage().isPresent()) {
            return this;
        }

        if (this.getBody().has("archives")) {
            for (int i = 0; i < this.getBody().getJSONArray("archives").length(); i++) {
                this.archives.add(this.getBody().getJSONArray("archives").getString(i));
            }
        }

        return this;
    }
}
