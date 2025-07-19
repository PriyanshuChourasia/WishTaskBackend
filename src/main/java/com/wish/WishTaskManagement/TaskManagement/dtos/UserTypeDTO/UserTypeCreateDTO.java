package com.wish.WishTaskManagement.TaskManagement.dtos.UserTypeDTO;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class UserTypeCreateDTO {

    @NotNull(message = "Name is required")
    private String name;

    private String description;

    private String alias;

    private int level;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

}
