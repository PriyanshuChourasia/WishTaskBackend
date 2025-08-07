package com.wish.WishTaskManagement.TaskManagement.services;

import com.wish.WishTaskManagement.TaskManagement.dtos.ProjectDTO.ProjectCreateDTO;
import com.wish.WishTaskManagement.TaskManagement.dtos.ProjectDTO.ProjectResponseDTO;

import java.util.List;
import java.util.UUID;

public interface ProjectService {

    List<ProjectResponseDTO> getById(UUID id);
    ProjectResponseDTO create(ProjectCreateDTO projectCreateDTO);
}
