package com.wish.WishTaskManagement.TaskManagement.controllers;


import com.wish.WishTaskManagement.TaskManagement.dtos.requestDTO.SignInRequestDTO;
import com.wish.WishTaskManagement.TaskManagement.dtos.responseDTO.SignInResponseDTO;
import com.wish.WishTaskManagement.TaskManagement.services.impl.AuthServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthServiceImpl authService;

    @PostMapping("/signin")
    public ResponseEntity<Object> signIn(@Valid @RequestBody SignInRequestDTO signInRequestDTO){
//        try{
            SignInResponseDTO signInResponseDTO = authService.signin(signInRequestDTO);
            Map<String,Object> obj = new HashMap<>();
            obj.put("data",signInResponseDTO);
            obj.put("success",true);
            return ResponseEntity.status(HttpStatus.OK).body(obj);
//        }catch (AuthenticationException e){
//            Map<String,Object> obj = new HashMap<>();
//            Map<String,String> res = new HashMap<>();
//            res.put("message","Authentication Failed");
//            obj.put("errros",res);
//            obj.put("success",true);
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(obj);
//        }
    }
}
