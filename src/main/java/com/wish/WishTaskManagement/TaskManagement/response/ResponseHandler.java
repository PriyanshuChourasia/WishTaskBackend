package com.wish.WishTaskManagement.TaskManagement.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
    public static <T> ResponseEntity<Object> responseBuilder(HttpStatus httpStatus, T responseObject){
        Map<String,Object> response = new HashMap<>();
        Map<String,Object> result = new HashMap<>();
        result.put("results",responseObject);
        response.put("data",result);
        response.put("success",true);
        return new ResponseEntity<>(response,httpStatus);
    }

    public static <T> ResponseEntity<Object> responseBuilder(HttpStatus httpStatus, Iterable<T> responseList){
        Map<String,Object> response = new HashMap<>();
        Map<String,Object> result = new HashMap<>();
        result.put("results",responseList);
        response.put("data",result);
        response.put("success",true);
        return new  ResponseEntity<>(response,httpStatus);
    }

    public static  <T> ResponseEntity<Object> responseBuilder(HttpStatus httpStatus, String responseMessage){
        Map<String,String> msg = new HashMap<>();
        Map<String,Object> response = new HashMap<>();
        msg.put("message",responseMessage);
        response.put("data",msg);
        response.put("success",true);
        return new ResponseEntity<>(response,httpStatus);
    }
}
