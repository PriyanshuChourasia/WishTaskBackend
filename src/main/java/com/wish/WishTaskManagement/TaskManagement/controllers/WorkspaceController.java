package com.wish.WishTaskManagement.TaskManagement.controllers;

import com.wish.WishTaskManagement.TaskManagement.dtos.Workspace.WorkspaceCreateDTO;
import com.wish.WishTaskManagement.TaskManagement.dtos.Workspace.WorkspaceResponseDTO;
import com.wish.WishTaskManagement.TaskManagement.response.ResponseHandler;
import com.wish.WishTaskManagement.TaskManagement.services.WorkspaceService;
import com.wish.WishTaskManagement.TaskManagement.services.impl.WorkSpaceServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/workspace")
public class WorkspaceController {

    @Autowired
    private WorkSpaceServiceImpl workSpaceService;

    @GetMapping("/{id}")
    public ResponseEntity<Object> getAll(@Valid @PathVariable UUID id){
        List<WorkspaceResponseDTO> workspaceResponseDTOS = workSpaceService.getAll(id);
        return ResponseHandler.responseBuilder(HttpStatus.OK,workspaceResponseDTOS);
    }

    @PostMapping("")
    public ResponseEntity<Object> create(@Valid @RequestBody WorkspaceCreateDTO workspaceCreateDTO){
        WorkspaceResponseDTO workspaceResponseDTO = workSpaceService.create(workspaceCreateDTO);
        return ResponseHandler.responseBuilder(HttpStatus.CREATED,workspaceResponseDTO);
    }
}
