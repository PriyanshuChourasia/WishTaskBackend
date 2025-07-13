package com.wish.WishTaskManagement.TaskManagement.controllers;


import com.wish.WishTaskManagement.TaskManagement.config.jwt.JwtUtils;
import com.wish.WishTaskManagement.TaskManagement.dtos.requestDTO.UserRequestDTO;
import com.wish.WishTaskManagement.TaskManagement.dtos.responseDTO.UserResponseDTO;
import com.wish.WishTaskManagement.TaskManagement.services.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private JwtUtils jwtUtils;


    @PostMapping("/create")
    public ResponseEntity<Object> create(@Valid @RequestBody UserRequestDTO userRequestDTO){
        UserResponseDTO userResponseDTO = userService.create(userRequestDTO);
        Map<String,Object> obj = new HashMap<>();
        obj.put("data",userResponseDTO);
        obj.put("success",true);
        return ResponseEntity.status(HttpStatus.CREATED).body(obj);
    }

    @GetMapping("/details")
    public ResponseEntity<Object> getDetail(HttpServletRequest httpServletRequest){
        String token = httpServletRequest.getHeader("Authorization");
        Map<String,Object> obj = new HashMap<>();
        Map<String,String> res = new HashMap<>();
        res.put("Username",token);
        obj.put("data",res);
        obj.put("success",true);
        return ResponseEntity.status(HttpStatus.OK).body(obj);
    }
}
