package com.wish.WishTaskManagement.TaskManagement.services;

import com.wish.WishTaskManagement.TaskManagement.dtos.TaskDTO.TaskRequestDTO;
import com.wish.WishTaskManagement.TaskManagement.dtos.TaskDTO.TaskResponseDTO;

import java.util.List;
import java.util.UUID;

public interface TaskService {

    TaskResponseDTO createTask(TaskRequestDTO taskRequestDTO);

    List<TaskResponseDTO> getAllTaskById(UUID id);
}
