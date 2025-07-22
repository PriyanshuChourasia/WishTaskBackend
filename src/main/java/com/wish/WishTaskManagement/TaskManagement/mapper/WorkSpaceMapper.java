package com.wish.WishTaskManagement.TaskManagement.mapper;

import com.wish.WishTaskManagement.TaskManagement.dtos.Workspace.WorkspaceResponseDTO;
import com.wish.WishTaskManagement.TaskManagement.entities.User;
import com.wish.WishTaskManagement.TaskManagement.entities.Workspace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WorkSpaceMapper {

    private final static Logger logger = LoggerFactory.getLogger(WorkSpaceMapper.class);

    public static WorkspaceResponseDTO toDTO(Workspace workspace){
        WorkspaceResponseDTO workspaceResponseDTO = new WorkspaceResponseDTO();
        workspaceResponseDTO.setId(workspace.getId().toString());
        workspaceResponseDTO.setName(workspace.getName());
        workspaceResponseDTO.setShared(workspace.getShared());
        workspaceResponseDTO.setViewMode(workspace.getViewMode().toString());
        User user = workspace.getWorkspaceuser();
        workspaceResponseDTO.setCreatedBy(user.getName());
        return workspaceResponseDTO;
    }
}
