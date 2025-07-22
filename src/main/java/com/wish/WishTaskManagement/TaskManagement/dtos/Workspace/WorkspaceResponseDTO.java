package com.wish.WishTaskManagement.TaskManagement.dtos.Workspace;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wish.WishTaskManagement.TaskManagement.entities.User;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class WorkspaceResponseDTO {
    private String id;

    private String name;


    private String viewMode;

    private Boolean shared;

    private String createdBy;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getViewMode() {
        return viewMode;
    }

    public void setViewMode(String viewMode) {
        this.viewMode = viewMode;
    }

    public Boolean getShared() {
        return shared;
    }

    public void setShared(Boolean shared) {
        this.shared = shared;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

}
