package org.ceborn.http.secondaries;

import lombok.Getter;
import org.json.JSONObject;

import java.util.Date;

@Getter
public class ClubData {

    private final String id;
    private final String name;
    private final Date lastActivity;
    private final String icon;
    private final String url;
    private final Date joined;

    public ClubData(JSONObject json) {
        this.id = json.getString("@id");
        this.name = json.getString("name");
        this.lastActivity = new Date(json.getLong("last_activity") * 1000);
        this.icon = json.getString("icon");
        this.url = json.getString("url");
        this.joined = new Date(json.getLong("joined") * 1000);
    }
}
