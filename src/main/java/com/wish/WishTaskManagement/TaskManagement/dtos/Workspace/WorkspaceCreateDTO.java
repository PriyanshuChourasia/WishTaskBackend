package com.wish.WishTaskManagement.TaskManagement.dtos.Workspace;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class WorkspaceCreateDTO {

    @NotNull(message = "Name is required")
    @Size(min = 5, max = 100, message = "Name cannot be less than 5 characters or greater than 100 characters")
    private String name;

    @NotNull(message = "Created by Id is required")
    private String createdBy;


    private String viewMode;

    private boolean shared;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }


    public String getViewMode() {
        return viewMode;
    }

    public void setViewMode(String viewMode) {
        this.viewMode = viewMode;
    }
    public boolean isShared() {
        return shared;
    }

    public void setShared(boolean shared) {
        this.shared = shared;
    }

}
