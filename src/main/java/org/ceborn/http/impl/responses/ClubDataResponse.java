package org.ceborn.http.impl.responses;

import lombok.Getter;
import org.ceborn.builders.ClubDataResponseBuilder;
import org.ceborn.http.impl.VisibilityClub;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class ClubDataResponse extends AbstractResponse<ClubDataResponse> {

    @Getter
    private String id;

    @Getter
    private String name;

    @Getter
    private int club_id;

    @Getter
    private String country;

    @Getter
    private int averageDailyRating;

    @Getter
    private int membersCount;

    @Getter
    private Date created;

    @Getter
    private Date lastActivity;

    @Getter
    private VisibilityClub visibility;

    @Getter
    private String joinRequest;

    @Getter
    private final List<String> admin = new ArrayList<>();

    @Getter
    private String description;

    private String icon;

    private ClubDataResponse() {
    }

    public static ClubDataResponseBuilder newBuilder() {
        return new ClubDataResponseBuilder(new ClubDataResponse());
    }

    @Override
    public ClubDataResponse load() {
        this.id = this.getBody().getString("@id");
        this.name = this.getBody().getString("name");
        this.club_id = this.getBody().getInt("club_id");
        this.icon = this.getBody().has("icon") ? this.getBody().getString("icon") : null;
        this.country = this.getBody().getString("country");
        this.averageDailyRating = this.getBody().getInt("average_daily_rating");
        this.membersCount = this.getBody().getInt("members_count");
        this.created = new Date(this.getBody().getLong("created") * 1000);
        this.lastActivity = new Date(this.getBody().getLong("last_activity") * 1000);
        this.visibility = VisibilityClub.getEnum(this.getBody().getString("visibility"));
        this.joinRequest = this.getBody().getString("join_request");
        this.description = this.getBody().getString("description");

        for (int i = 0; i < this.getBody().getJSONArray("admin").length(); i++) {
            this.admin.add(this.getBody().getJSONArray("admin").getString(i));
        }

        return this;
    }

    public Optional<String> getIcon() {
        return Optional.ofNullable(this.icon);
    }
}
