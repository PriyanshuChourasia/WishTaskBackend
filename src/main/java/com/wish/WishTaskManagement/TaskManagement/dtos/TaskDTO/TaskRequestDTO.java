package com.wish.WishTaskManagement.TaskManagement.dtos.TaskDTO;

import java.time.Instant;

public class TaskRequestDTO {
    private String name;
    private String description;

    private String createdBy;

    private String assignedBy;

    private String assignedTo;

    private Instant assignedDate = Instant.now();

    private Instant startDate = Instant.now();


    private Instant tentativeDate = Instant.now();

    private String status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getAssignedBy() {
        return assignedBy;
    }

    public void setAssignedBy(String assignedBy) {
        this.assignedBy = assignedBy;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public Instant getAssignedDate() {
        return assignedDate;
    }

    public void setAssignedDate(Instant assignedDate) {
        this.assignedDate = assignedDate;
    }

    public Instant getStartDate() {
        return startDate;
    }

    public void setStartDate(Instant startDate) {
        this.startDate = startDate;
    }

    public Instant getTentativeDate() {
        return tentativeDate;
    }

    public void setTentativeDate(Instant tentativeDate) {
        this.tentativeDate = tentativeDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
