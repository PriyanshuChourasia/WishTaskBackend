package com.wish.WishTaskManagement.TaskManagement.dtos.TeamMemberDTO;

import jakarta.validation.constraints.NotNull;

public class TeamMemberCreateDTO {

    @NotNull
    private String userId;

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @NotNull
    private String teamId;
}
