package com.wish.WishTaskManagement.TaskManagement.dtos.TeamDTO;


import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TeamResponseDTO {
    private String name;

    private String alias;

    private String description;

    private LocalDateTime createdAt;

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

    public LocalDateTime getCreatedAt(){
        return this.createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt){
        this.createdAt = createdAt;
    }
}
