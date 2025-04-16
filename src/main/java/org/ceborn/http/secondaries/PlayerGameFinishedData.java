package org.ceborn.http.secondaries;

import lombok.Getter;
import org.json.JSONObject;

@Getter
public class PlayerGameFinishedData {

    private final String username;
    private final int rating;
    private final String result;
    private final String id;
    private final String uuid;

    public PlayerGameFinishedData(JSONObject json) {
        this.username = json.getString("username");
        this.rating = json.getInt("rating");
        this.result = json.getString("result");
        this.id = json.getString("@id");
        this.uuid = json.getString("uuid");
    }

}
