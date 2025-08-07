package com.wish.WishTaskManagement.TaskManagement.dtos.ProjectDTO;

import jakarta.validation.constraints.NotNull;

import java.time.Instant;

public class ProjectCreateDTO {
    @NotNull(message = "Name is required")
    private String name;

    private String topic;
    private String description;
    private Instant startDate = Instant.now();

    private Instant dueDate = Instant.now();

    private String workspaceId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Instant getStartDate() {
        return startDate;
    }

    public void setStartDate(Instant startDate) {
        this.startDate = startDate;
    }

    public Instant getDueDate() {
        return dueDate;
    }

    public void setDueDate(Instant dueDate) {
        this.dueDate = dueDate;
    }

    public String getWorkspaceId() {
        return workspaceId;
    }

    public void setWorkspaceId(String workspaceId) {
        this.workspaceId = workspaceId;
    }


}
