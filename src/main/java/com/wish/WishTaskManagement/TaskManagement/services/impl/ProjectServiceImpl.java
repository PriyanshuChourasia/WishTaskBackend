package com.wish.WishTaskManagement.TaskManagement.services.impl;

import com.wish.WishTaskManagement.TaskManagement.dtos.ProjectDTO.ProjectCreateDTO;
import com.wish.WishTaskManagement.TaskManagement.dtos.ProjectDTO.ProjectResponseDTO;
import com.wish.WishTaskManagement.TaskManagement.entities.Project;
import com.wish.WishTaskManagement.TaskManagement.entities.Workspace;
import com.wish.WishTaskManagement.TaskManagement.exceptions.DataNotExistsValidation;
import com.wish.WishTaskManagement.TaskManagement.mapper.ProjectMapper;
import com.wish.WishTaskManagement.TaskManagement.repositories.ProjectRepository;
import com.wish.WishTaskManagement.TaskManagement.repositories.WorkSpaceRepository;
import com.wish.WishTaskManagement.TaskManagement.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private WorkSpaceRepository workSpaceRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<ProjectResponseDTO> getById(UUID workspaceId){
        List<Project> projects = projectRepository.findByWorkspaceId(workspaceId);
        List<ProjectResponseDTO> projectResponseDTOS = projects.stream().map(project -> ProjectMapper.toDTO(project)).toList();
        return projectResponseDTOS;
    }

    @Override
    public ProjectResponseDTO create(ProjectCreateDTO projectCreateDTO){
        Workspace workspace = workSpaceRepository.findById(UUID.fromString(projectCreateDTO.getWorkspaceId())).orElseThrow(()-> new DataNotExistsValidation("Workspace doesn't exists"));
        Project project = new Project();
        project.setName(projectCreateDTO.getName());
        project.setDescription(projectCreateDTO.getDescription());
        project.setDueDate(projectCreateDTO.getDueDate());
        project.setStartDate(projectCreateDTO.getStartDate());
        project.setTopic(projectCreateDTO.getTopic());
        project.setWorkspace(workspace);
        Project createProject = projectRepository.save(project);
        return ProjectMapper.toDTO(createProject);
    }
}
