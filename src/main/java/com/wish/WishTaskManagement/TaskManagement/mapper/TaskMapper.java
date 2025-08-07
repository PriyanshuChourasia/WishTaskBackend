package com.wish.WishTaskManagement.TaskManagement.mapper;

import com.wish.WishTaskManagement.TaskManagement.dtos.TaskDTO.TaskResponseDTO;
import com.wish.WishTaskManagement.TaskManagement.dtos.responseDTO.UserResponseDTO;
import com.wish.WishTaskManagement.TaskManagement.entities.Task;
import com.wish.WishTaskManagement.TaskManagement.entities.User;

import java.util.Map;
import java.util.UUID;

public class TaskMapper {
    public static TaskResponseDTO toDTO(Task task, Map<UUID, User> userMap){
        TaskResponseDTO taskResponseDTO = new TaskResponseDTO();
        taskResponseDTO.setId(task.getId().toString());
        taskResponseDTO.setAssignedDate(task.getAssignedDate());
        taskResponseDTO.setDescription(task.getDescription());
        taskResponseDTO.setName(task.getName());
        taskResponseDTO.setStatus(task.getStatus().toString());
        taskResponseDTO.setCreatedAt(task.getCreatedAt());
        taskResponseDTO.setStartDate(task.getStartDate());
        taskResponseDTO.setTentativeDate(task.getTentativeDate());
        taskResponseDTO.setUpdatedAt(task.getUpdatedAt());

        User createdBy = userMap.get(task.getCreatedBy());
        User assignedBy = userMap.get(task.getAssignedBy());
        User assignedTo = userMap.get(task.getAssignedTo());

        taskResponseDTO.setCreatedBy(new UserResponseDTO(createdBy.getId().toString(),createdBy.getName()));
        taskResponseDTO.setAssignedBy(new UserResponseDTO(assignedBy.getId().toString(),assignedBy.getName()));
        taskResponseDTO.setAssignedTo(new UserResponseDTO(assignedTo.getId().toString(),assignedTo.getName()));

        return taskResponseDTO;
    }
}
