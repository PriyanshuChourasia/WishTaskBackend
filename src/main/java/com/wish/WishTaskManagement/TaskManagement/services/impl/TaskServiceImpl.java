package com.wish.WishTaskManagement.TaskManagement.services.impl;


import com.wish.WishTaskManagement.TaskManagement.dtos.TaskDTO.TaskRequestDTO;
import com.wish.WishTaskManagement.TaskManagement.dtos.TaskDTO.TaskResponseDTO;
import com.wish.WishTaskManagement.TaskManagement.dtos.responseDTO.UserResponseDTO;
import com.wish.WishTaskManagement.TaskManagement.entities.Task;
import com.wish.WishTaskManagement.TaskManagement.entities.User;
import com.wish.WishTaskManagement.TaskManagement.exceptions.DataNotExistsValidation;
import com.wish.WishTaskManagement.TaskManagement.mapper.TaskMapper;
import com.wish.WishTaskManagement.TaskManagement.repositories.TaskRepository;
import com.wish.WishTaskManagement.TaskManagement.repositories.UserRepository;
import com.wish.WishTaskManagement.TaskManagement.services.TaskService;
import com.wish.WishTaskManagement.TaskManagement.utils.enums.PriorityEnum;
import com.wish.WishTaskManagement.TaskManagement.utils.enums.WorkStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public TaskResponseDTO createTask(TaskRequestDTO taskRequestDTO){
        User user = userRepository.findById(UUID.fromString(taskRequestDTO.getCreatedBy())).orElseThrow(()-> new DataNotExistsValidation("User doesn't exists"));
        Task task = new Task();
        task.setName(taskRequestDTO.getName());
        task.setCreatedBy(UUID.fromString(taskRequestDTO.getCreatedBy()));
        task.setDescription(taskRequestDTO.getDescription());
        task.setAssignedBy(UUID.fromString(taskRequestDTO.getAssignedBy()));
        task.setAssignedTo(UUID.fromString(taskRequestDTO.getAssignedTo()));
        task.setAssignedDate(taskRequestDTO.getAssignedDate());
        task.setStartDate(taskRequestDTO.getStartDate());
        task.setStatus(WorkStatusEnum.valueOf(taskRequestDTO.getStatus()));
        task.setTentativeDate(taskRequestDTO.getTentativeDate());
        task.setPriority(PriorityEnum.valueOf(taskRequestDTO.getPriority()));
        Task createdTask = taskRepository.save(task);
        TaskResponseDTO taskResponseDTO = new TaskResponseDTO();
        taskResponseDTO.setName(createdTask.getName());
        taskResponseDTO.setUpdatedAt(createdTask.getUpdatedAt());
        taskResponseDTO.setCreatedAt(createdTask.getCreatedAt());
        taskResponseDTO.setCreatedBy(new UserResponseDTO(user.getId().toString(),user.getName()));
        taskResponseDTO.setId(createdTask.getId().toString());
        taskResponseDTO.setTentativeDate(createdTask.getTentativeDate());
        taskResponseDTO.setDescription(createdTask.getDescription());
        taskResponseDTO.setCreatedAt(createdTask.getCreatedAt());
        taskResponseDTO.setAssignedDate(createdTask.getAssignedDate());
        taskResponseDTO.setStartDate(createdTask.getStartDate());
        taskResponseDTO.setStatus(createdTask.getStatus().toString());
        taskResponseDTO.setAssignedBy(new UserResponseDTO(user.getId().toString(),user.getName()));
        taskResponseDTO.setAssignedTo(new UserResponseDTO(user.getId().toString(),user.getName()));
        return taskResponseDTO;
    }


    public List<TaskResponseDTO> getAllTaskById(UUID id){
        List<Task> tasks = taskRepository.findByCreatedByOrAssignedTo(id,id);

        Set<UUID> userIds = tasks.stream().flatMap(t-> Stream.of(t.getCreatedBy(), t.getAssignedBy(), t.getAssignedTo())).collect(Collectors.toSet());

        Map<UUID, User> userMap = userRepository.findAllById(userIds).stream().collect(Collectors.toMap(User::getId, Function.identity()));
        return tasks.stream().map(task -> TaskMapper.toDTO(task,userMap)).toList();
    }
}
