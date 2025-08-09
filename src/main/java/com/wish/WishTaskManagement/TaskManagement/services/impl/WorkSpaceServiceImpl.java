package com.wish.WishTaskManagement.TaskManagement.services.impl;


import com.wish.WishTaskManagement.TaskManagement.dtos.Workspace.WorkspaceCreateDTO;
import com.wish.WishTaskManagement.TaskManagement.dtos.Workspace.WorkspaceDetailResponseDTO;
import com.wish.WishTaskManagement.TaskManagement.dtos.Workspace.WorkspaceResponseDTO;
import com.wish.WishTaskManagement.TaskManagement.dtos.Workspace.WorkspaceViewStatusUpdateDTO;
import com.wish.WishTaskManagement.TaskManagement.entities.Project;
import com.wish.WishTaskManagement.TaskManagement.entities.User;
import com.wish.WishTaskManagement.TaskManagement.entities.Workspace;
import com.wish.WishTaskManagement.TaskManagement.exceptions.DataNotExistsValidation;
import com.wish.WishTaskManagement.TaskManagement.mapper.WorkSpaceMapper;
import com.wish.WishTaskManagement.TaskManagement.repositories.ProjectRepository;
import com.wish.WishTaskManagement.TaskManagement.repositories.UserRepository;
import com.wish.WishTaskManagement.TaskManagement.repositories.WorkSpaceRepository;
import com.wish.WishTaskManagement.TaskManagement.services.WorkspaceService;
import com.wish.WishTaskManagement.TaskManagement.utils.enums.ViewEnumStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class WorkSpaceServiceImpl implements WorkspaceService {


    @Autowired
    private WorkSpaceRepository workSpaceRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<WorkspaceResponseDTO> getAll(UUID id){
        List<Workspace> workspaces = workSpaceRepository.findByWorkspaceuser_Id(id);
        List<WorkspaceResponseDTO> workspaceResponseDTOS = workspaces.stream().map(workspace -> WorkSpaceMapper.toDTO(workspace)).toList();
        return workspaceResponseDTOS;
    }

    @Override
    public WorkspaceDetailResponseDTO getWorkspaceDetailById(UUID workspaceId){
        Workspace workspace = workSpaceRepository.findById(workspaceId).orElseThrow(()-> new DataNotExistsValidation("Workspace doesn't exists"));
        List<Project> projects = projectRepository.findByWorkspaceId(workspaceId);
        WorkspaceDetailResponseDTO workspaceDetailResponseDTO = new WorkspaceDetailResponseDTO();
        workspaceDetailResponseDTO.setId(workspace.getId().toString());
        workspaceDetailResponseDTO.setCreatedAt(workspace.getCreatedAt().toString());
        User user = workspace.getWorkspaceuser();
        workspaceDetailResponseDTO.setCreatedBy(user.getName());
        workspaceDetailResponseDTO.setNoOfProjects(projects.size());
        workspaceDetailResponseDTO.setShared(workspace.getShared());
        workspaceDetailResponseDTO.setViewMode(workspace.getViewMode().toString());
        workspaceDetailResponseDTO.setName(workspace.getName());
        return workspaceDetailResponseDTO;
    }

    @Override
    public WorkspaceResponseDTO create(WorkspaceCreateDTO workspaceCreateDTO){
        Workspace workspace = new Workspace();
        workspace.setName(workspaceCreateDTO.getName());
        workspace.setViewMode(ViewEnumStatus.valueOf(workspaceCreateDTO.getViewMode()));
        if(workspaceCreateDTO.getCreatedBy() != null){
            User user = userRepository.findById(UUID.fromString(workspaceCreateDTO.getCreatedBy())).orElseThrow(()-> new DataNotExistsValidation("User doesn't exists"));
            workspace.setWorkspaceuser(user);
        }
        workspace.setShared(workspaceCreateDTO.isShared());
        Workspace createWorkspace = workSpaceRepository.save(workspace);
        return WorkSpaceMapper.toDTO(createWorkspace);
    }

    @Override
    public void updateViewMode(UUID id, WorkspaceViewStatusUpdateDTO workspaceViewStatusUpdateDTO){
        Workspace workspace = workSpaceRepository.findById(id).orElseThrow(()-> new DataNotExistsValidation("Workspace doesn't exists"));
        workspace.setViewMode(ViewEnumStatus.valueOf(workspaceViewStatusUpdateDTO.getViewMode()));
        workSpaceRepository.save(workspace);
    }

    @Override
    public void destroy(UUID id){
        Workspace workspace = workSpaceRepository.findById(id).orElseThrow(()-> new DataNotExistsValidation("Workspace doesn't exists"));
        workSpaceRepository.delete(workspace);
    }

    @Override
    public void workspaceShareUpdate(UUID id, boolean share){
        Workspace workspace = workSpaceRepository.findById(id).orElseThrow(()-> new DataNotExistsValidation("Workspace doesn't exists"));
        workspace.setShared(share);
        workSpaceRepository.save(workspace);
    }
}
