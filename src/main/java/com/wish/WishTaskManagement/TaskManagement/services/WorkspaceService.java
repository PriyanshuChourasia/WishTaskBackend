package com.wish.WishTaskManagement.TaskManagement.services;

import com.wish.WishTaskManagement.TaskManagement.dtos.Workspace.WorkspaceCreateDTO;
import com.wish.WishTaskManagement.TaskManagement.dtos.Workspace.WorkspaceDetailResponseDTO;
import com.wish.WishTaskManagement.TaskManagement.dtos.Workspace.WorkspaceResponseDTO;
import com.wish.WishTaskManagement.TaskManagement.dtos.Workspace.WorkspaceViewStatusUpdateDTO;

import java.util.List;
import java.util.UUID;

public interface WorkspaceService {

//    List<WorkspaceResponseDTO> getAll();

    WorkspaceDetailResponseDTO getWorkspaceDetailById(UUID id);

    List<WorkspaceResponseDTO> getAll(UUID id);

    WorkspaceResponseDTO create(WorkspaceCreateDTO workspaceCreateDTO);

    void updateViewMode(UUID id,WorkspaceViewStatusUpdateDTO workspaceViewStatusUpdateDTO);

//    Workspace ID to delete workspace
    void destroy(UUID id);

//    Workspace share function
    void workspaceShareUpdate(UUID id, boolean share);
}
