package com.wish.WishTaskManagement.TaskManagement.mapper;

import com.wish.WishTaskManagement.TaskManagement.dtos.ProjectDTO.ProjectResponseDTO;
import com.wish.WishTaskManagement.TaskManagement.entities.Project;

public class ProjectMapper {
    public static ProjectResponseDTO toDTO(Project project){
        ProjectResponseDTO projectResponseDTO = new ProjectResponseDTO();
        projectResponseDTO.setName(project.getName());
        projectResponseDTO.setTopic(project.getTopic());
        projectResponseDTO.setDescription(project.getDescription());
        projectResponseDTO.setStartDate(project.getStartDate());
        projectResponseDTO.setDueDate(project.getDueDate());
        projectResponseDTO.setCreatedAt(project.getCreatedAt());
        return projectResponseDTO;
    }
}
