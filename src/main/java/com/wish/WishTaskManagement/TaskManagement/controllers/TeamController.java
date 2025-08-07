package com.wish.WishTaskManagement.TaskManagement.controllers;


import com.wish.WishTaskManagement.TaskManagement.dtos.TeamDTO.TeamCreateDTO;
import com.wish.WishTaskManagement.TaskManagement.dtos.TeamDTO.TeamResponseDTO;
import com.wish.WishTaskManagement.TaskManagement.response.ResponseHandler;
import com.wish.WishTaskManagement.TaskManagement.services.impl.TeamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/team")
public class TeamController {

    @Autowired
    private TeamServiceImpl teamService;

    @GetMapping("/{id}")
    public ResponseEntity<Object> getAllById(UUID id){
        List<TeamResponseDTO> teamResponseDTOS = teamService.getAllById(id);
        return ResponseHandler.responseBuilder(HttpStatus.OK,teamResponseDTOS);
    }

    @PostMapping("")
    public ResponseEntity<Object> create(TeamCreateDTO teamCreateDTO){
        TeamResponseDTO teamResponseDTO = teamService.create(teamCreateDTO);
        return ResponseHandler.responseBuilder(HttpStatus.CREATED,teamResponseDTO);
    }

}
