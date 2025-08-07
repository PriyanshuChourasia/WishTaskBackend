package com.wish.WishTaskManagement.TaskManagement.dtos.TaskDTO;


import com.wish.WishTaskManagement.TaskManagement.dtos.responseDTO.UserResponseDTO;

import java.time.Instant;

public class TaskResponseDTO {

    private String id;
    private String name;
    private String description;

    public UserResponseDTO getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UserResponseDTO createdBy) {
        this.createdBy = createdBy;
    }

    public UserResponseDTO getAssignedBy() {
        return assignedBy;
    }

    public void setAssignedBy(UserResponseDTO assignedBy) {
        this.assignedBy = assignedBy;
    }

    public UserResponseDTO getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(UserResponseDTO assignedTo) {
        this.assignedTo = assignedTo;
    }

    private UserResponseDTO createdBy;

    private UserResponseDTO assignedBy;

    private UserResponseDTO assignedTo;

    private Instant assignedDate = Instant.now();

    private Instant startDate = Instant.now();


    private Instant tentativeDate = Instant.now();

    private String status;

    private Instant createdAt;

    private Instant updatedAt;


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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

}
