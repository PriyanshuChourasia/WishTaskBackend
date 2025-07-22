package com.wish.WishTaskManagement.TaskManagement.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationException(MethodArgumentNotValidException ex){
        Map<String,Object> obj = new HashMap<>();
        Map<String,String> res = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> res.put(error.getField(), error.getDefaultMessage()));
        obj.put("errors",res);
        obj.put("success",false);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(obj);
    }

//    JWT exception handler
    @ExceptionHandler(JWTExceptionHandler.class)
    public ResponseEntity<Object> handleJWTExceptions(JWTExceptionHandler ex){
        Map<String,String> res = new HashMap<>();
        Map<String,Object> obj = new HashMap<>();

        res.put("message",ex.getMessage());
        obj.put("errors",res);
        obj.put("success",false);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(obj);
    }

//    Data not Exists
    @ExceptionHandler(DataNotExistsValidation.class)
    public ResponseEntity<Object> handleNotExistsValidation(DataNotExistsValidation ex){
        Map<String,Object> obj = new HashMap<>();
        Map<String,String> res = new HashMap<>();

        res.put("message",ex.getMessage());
        obj.put("errors",res);
        obj.put("success",false);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(obj);
    }

//    Data Exists
    @ExceptionHandler(DataExistsValidation.class)
    public ResponseEntity<Object> handleExistsValidation(DataExistsValidation ex){
        Map<String,Object> obj = new HashMap<>();
        Map<String,String> res = new HashMap<>();
        res.put("message",ex.getMessage());
        obj.put("errors",res);
        obj.put("success",false);
        return ResponseEntity.status(HttpStatus.FOUND).body(obj);
    }
}
