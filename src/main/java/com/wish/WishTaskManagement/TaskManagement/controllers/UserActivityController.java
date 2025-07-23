package com.wish.WishTaskManagement.TaskManagement.controllers;


import com.wish.WishTaskManagement.TaskManagement.dtos.UserActivityDTO.UserActivityCreateDTO;
import com.wish.WishTaskManagement.TaskManagement.dtos.UserActivityDTO.UserActivityResponseDTO;
import com.wish.WishTaskManagement.TaskManagement.response.ResponseHandler;
import com.wish.WishTaskManagement.TaskManagement.services.impl.UserActivityServiceImpl;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/activity")
public class UserActivityController {

    private final static Logger logger = LoggerFactory.getLogger(UserActivityController.class);

    @Autowired
    private UserActivityServiceImpl userActivityService;

    @GetMapping("/{id}")
    public ResponseEntity<Object> getAllActivity(@Valid @PathVariable UUID id){
        List<UserActivityResponseDTO> userActivityResponseDTOS = userActivityService.getAllActivity(id);
        return ResponseHandler.responseBuilder(HttpStatus.OK,userActivityResponseDTOS);
    }

    @PostMapping("")
    public ResponseEntity<Object> createActivity(@Valid @RequestBody UserActivityCreateDTO userActivityCreateDTO){
        logger.info("UserActivity {}",userActivityCreateDTO);
        UserActivityResponseDTO userActivityResponseDTO = userActivityService.createActivity(userActivityCreateDTO);
        return ResponseHandler.responseBuilder(HttpStatus.CREATED,userActivityResponseDTO);
    }


}
