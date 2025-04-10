package org.ceborn.http.secondaries;

import lombok.Getter;
import org.json.JSONObject;

import java.util.Date;

@Getter
public class MemberData {

    private final String username;
    private final Date joined;

    public MemberData(JSONObject json) {
        this.username = json.getString("username");
        this.joined = new Date(json.getLong("joined") * 1000);
    }

}
