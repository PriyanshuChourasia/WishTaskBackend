package com.wish.WishTaskManagement.TaskManagement.services;

import com.wish.WishTaskManagement.TaskManagement.dtos.Workspace.WorkspaceCreateDTO;
import com.wish.WishTaskManagement.TaskManagement.dtos.Workspace.WorkspaceResponseDTO;

import java.util.List;
import java.util.UUID;

public interface WorkspaceService {

//    List<WorkspaceResponseDTO> getAll();

    List<WorkspaceResponseDTO> getAll(UUID id);

    WorkspaceResponseDTO create(WorkspaceCreateDTO workspaceCreateDTO);

//    Workspace ID to delete workspace
    void destroy(UUID id);
}
