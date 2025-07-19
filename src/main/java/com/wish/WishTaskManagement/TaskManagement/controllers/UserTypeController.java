package com.wish.WishTaskManagement.TaskManagement.controllers;


import com.wish.WishTaskManagement.TaskManagement.dtos.UserTypeDTO.UserTypeCreateDTO;
import com.wish.WishTaskManagement.TaskManagement.dtos.UserTypeDTO.UserTypeResponseDTO;
import com.wish.WishTaskManagement.TaskManagement.services.UserTypeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user_types")
public class UserTypeController {

    @Autowired
    private UserTypeService userTypeService;

    @GetMapping("")
    public ResponseEntity<Object> getAll(){
        List<UserTypeResponseDTO> userTypeResponseDTOS = userTypeService.getAll();
        Map<String,Object> response = new HashMap<>();
        response.put("data",userTypeResponseDTOS);
        response.put("success",true);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


    @PostMapping("")
    public ResponseEntity<Object> create(@Valid @RequestBody UserTypeCreateDTO userTypeCreateDTO){
        UserTypeResponseDTO userTypeResponseDTO = userTypeService.create(userTypeCreateDTO);
        Map<String,Object> resObj = new HashMap<>();
        resObj.put("data",userTypeResponseDTO);
        resObj.put("success",true);
        return ResponseEntity.status(HttpStatus.CREATED).body(resObj);
    }
}
