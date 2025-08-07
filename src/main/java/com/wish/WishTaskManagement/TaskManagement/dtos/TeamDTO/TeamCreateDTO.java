package com.wish.WishTaskManagement.TaskManagement.dtos.TeamDTO;

import jakarta.validation.constraints.NotNull;

public class TeamCreateDTO {
    @NotNull
    private String name;

    private String alias;

    private String description;

    @NotNull(message = "User Id cannot be null")
    private String userId;

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name= name;
    }

    public String getAlias(){
        return this.alias;
    }

    public void setAlias(String alias){
        this.alias = alias;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    public String getUserId(){
        return this.userId;
    }

    public void setUserId(String userId){
        this.userId = userId;
    }
}
