package com.wish.WishTaskManagement.TaskManagement.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping("")
    public ResponseEntity<Object> index(){
        Map<String,Object> res = new HashMap<>();
        Map<String,String> mapRes = new HashMap<>();
        mapRes.put("message","Welcome to Wish Task Management");
        res.put("data",mapRes);
        res.put("success",true);
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @GetMapping("health-check")
    public ResponseEntity<Object> health(){
        Map<String,Object> response = new HashMap<>();
        response.put("data",true);
        return  ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
