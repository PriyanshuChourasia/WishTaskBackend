package com.wish.WishTaskManagement.TaskManagement.entities;


import com.wish.WishTaskManagement.TaskManagement.utils.enums.ViewEnumStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "workspaces")
public class Workspace {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotNull(message = "Name is required")
    private String name;

    @NotNull(message = "User ID cannot be null")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User workspaceuser;

    @Enumerated(EnumType.STRING)
    @Column(name = "view_mode")
    private ViewEnumStatus viewMode = ViewEnumStatus.PUBLIC;

    private Boolean shared = true;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getWorkspaceuser() {
        return workspaceuser;
    }

    public void setWorkspaceuser(User workspaceuser) {
        this.workspaceuser = workspaceuser;
    }

    public ViewEnumStatus getViewMode() {
        return viewMode;
    }

    public void setViewMode(ViewEnumStatus viewMode) {
        this.viewMode = viewMode;
    }

    public Boolean getShared() {
        return shared;
    }

    public void setShared(Boolean shared) {
        this.shared = shared;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
