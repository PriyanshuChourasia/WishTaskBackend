package com.wish.WishTaskManagement.TaskManagement.controllers;

import com.wish.WishTaskManagement.TaskManagement.dtos.ProjectDTO.ProjectCreateDTO;
import com.wish.WishTaskManagement.TaskManagement.dtos.ProjectDTO.ProjectResponseDTO;
import com.wish.WishTaskManagement.TaskManagement.response.ResponseHandler;
import com.wish.WishTaskManagement.TaskManagement.services.impl.ProjectServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectServiceImpl projectService;


    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@Valid @PathVariable UUID id){
        List<ProjectResponseDTO> projectResponseDTOS = projectService.getById(id);
        return ResponseHandler.responseBuilder(HttpStatus.OK,projectResponseDTOS);
    }

    @PostMapping("")
    public ResponseEntity<Object> create(@Valid @RequestBody ProjectCreateDTO projectCreateDTO){
        ProjectResponseDTO projectResponseDTO = projectService.create(projectCreateDTO);
        return ResponseHandler.responseBuilder(HttpStatus.CREATED,projectResponseDTO);
    }
}
