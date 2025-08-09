package com.wish.WishTaskManagement.TaskManagement.controllers;


import com.wish.WishTaskManagement.TaskManagement.config.jwt.JwtUtils;
import com.wish.WishTaskManagement.TaskManagement.dtos.requestDTO.UserRequestDTO;
import com.wish.WishTaskManagement.TaskManagement.dtos.requestDTO.UserUpdateRequestDTO;
import com.wish.WishTaskManagement.TaskManagement.dtos.requestDTO.UserUpdateRoleDTO;
import com.wish.WishTaskManagement.TaskManagement.dtos.responseDTO.UserResponseDTO;
import com.wish.WishTaskManagement.TaskManagement.response.ResponseHandler;
import com.wish.WishTaskManagement.TaskManagement.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtils jwtUtils;

    @GetMapping("/all")
    public ResponseEntity<Object> getAll(){
        List<UserResponseDTO> userResponseDTOS = userService.getAll();
        Map<String,Object> response = new HashMap<>();
        Map<String,Object> result = new HashMap<>();
        result.put("result",userResponseDTOS);
        response.put("data",result);
        response.put("success",true);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


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
        String token = httpServletRequest.getHeader("Authorization").substring(7);
        UserResponseDTO userDetail = userService.userDetail(token);
        Map<String,Object> obj = new HashMap<>();
        obj.put("data",userDetail);
        obj.put("success",true);
        return ResponseEntity.status(HttpStatus.OK).body(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> destroy(@Valid @PathVariable UUID id){
        userService.destroy(id);
        Map<String,Object> response = new HashMap<>();
        Map<String,String> msg = new HashMap<>();
        msg.put("message","User deleted successfully");
        response.put("data",msg);
        response.put("success",true);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@Valid @PathVariable UUID id, @RequestBody UserUpdateRequestDTO userUpdateRequestDTO){
        UserResponseDTO userResponseDTO = userService.update(id,userUpdateRequestDTO);
        Map<String,Object> response = new HashMap<>();
        response.put("data",userResponseDTO);
        response.put("success",true);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> userRoleUpdate(@Valid @PathVariable UUID id, @RequestBody UserUpdateRoleDTO userUpdateRoleDTO){
        userService.updateRole(id,userUpdateRoleDTO);
        return ResponseHandler.responseBuilder(HttpStatus.OK,"User role updated successfully");
    }

}
