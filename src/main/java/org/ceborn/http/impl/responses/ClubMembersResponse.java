package org.ceborn.http.impl.responses;

import lombok.Getter;
import org.ceborn.builders.ClubMembersResponseBuilder;
import org.ceborn.http.secondaries.MemberData;
import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ClubMembersResponse extends AbstractResponse<ClubMembersResponse> {

    private List<MemberData> weekly;
    private List<MemberData> monthly;
    private List<MemberData> allTime;

    private ClubMembersResponse() {
    }

    public static ClubMembersResponseBuilder newBuilder() {
        return new ClubMembersResponseBuilder(new ClubMembersResponse());
    }

    @Override
    public ClubMembersResponse load() {
        if (this.getBody().has("weekly")) {
            this.weekly = this.loadMemberData(this.getBody().getJSONArray("weekly"));
        }

        if (this.getBody().has("monthly")) {
            this.monthly = this.loadMemberData(this.getBody().getJSONArray("monthly"));
        }

        if (this.getBody().has("all_time")) {
            this.allTime = this.loadMemberData(this.getBody().getJSONArray("all_time"));
        }

        return this;
    }

    private List<MemberData> loadMemberData(JSONArray jsonArray) {
        List<MemberData> list = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            list.add(new MemberData(jsonArray.getJSONObject(i)));
        }
        return list;
    }
}
