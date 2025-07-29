package com.wish.WishTaskManagement.TaskManagement.controllers;

import com.wish.WishTaskManagement.TaskManagement.dtos.Workspace.WorkspaceCreateDTO;
import com.wish.WishTaskManagement.TaskManagement.dtos.Workspace.WorkspaceResponseDTO;
import com.wish.WishTaskManagement.TaskManagement.dtos.Workspace.WorkspaceViewStatusUpdateDTO;
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

    @GetMapping("/details/{id}")
    public ResponseEntity<Object> getWorkspaceDetailById(@Valid @PathVariable UUID id){
        WorkspaceResponseDTO workspaceResponseDTO = workSpaceService.getWorkspaceDetailById(id);
        return ResponseHandler.responseBuilder(HttpStatus.OK,workspaceResponseDTO);
    }

    @PostMapping("")
    public ResponseEntity<Object> create(@Valid @RequestBody WorkspaceCreateDTO workspaceCreateDTO){
        WorkspaceResponseDTO workspaceResponseDTO = workSpaceService.create(workspaceCreateDTO);
        return ResponseHandler.responseBuilder(HttpStatus.CREATED,workspaceResponseDTO);
    }

    @PatchMapping("/view-status/{id}")
    public ResponseEntity<Object> viewStatus(@Valid @PathVariable UUID id, @RequestBody WorkspaceViewStatusUpdateDTO workspaceViewStatusUpdateDTO){
        workSpaceService.updateViewMode(id,workspaceViewStatusUpdateDTO);
        String message = "View Mode has been updated";
        return ResponseHandler.responseBuilder(HttpStatus.OK,message);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> destroy(@Valid @PathVariable UUID id){
        workSpaceService.destroy(id);
        String message = "Workspace has been deleted";
        return ResponseHandler.responseBuilder(HttpStatus.OK,message);
    }
}
