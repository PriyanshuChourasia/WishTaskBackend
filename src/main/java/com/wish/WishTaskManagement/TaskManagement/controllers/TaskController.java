package com.wish.WishTaskManagement.TaskManagement.controllers;

import com.wish.WishTaskManagement.TaskManagement.dtos.TaskDTO.TaskRequestDTO;
import com.wish.WishTaskManagement.TaskManagement.dtos.TaskDTO.TaskResponseDTO;
import com.wish.WishTaskManagement.TaskManagement.response.ResponseHandler;
import com.wish.WishTaskManagement.TaskManagement.services.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("")
    public ResponseEntity<Object> createTask(@Valid @RequestBody TaskRequestDTO taskRequestDTO){
        TaskResponseDTO taskResponseDTO = taskService.createTask(taskRequestDTO);
        return ResponseHandler.responseBuilder(HttpStatus.CREATED,taskResponseDTO);
    }

    @GetMapping("/all/{id}")
    public ResponseEntity<Object> getAll(@Valid @PathVariable UUID id){
        List<TaskResponseDTO> taskResponseDTOS = taskService.getAllTaskById(id);
        return ResponseHandler.responseBuilder(HttpStatus.OK,taskResponseDTOS);
    }
}
