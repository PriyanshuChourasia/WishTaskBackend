package com.wish.WishTaskManagement.TaskManagement.controllers;


import com.wish.WishTaskManagement.TaskManagement.dtos.CommentDTO.CommentRequestDTO;
import com.wish.WishTaskManagement.TaskManagement.dtos.CommentDTO.CommentResponseDTO;
import com.wish.WishTaskManagement.TaskManagement.response.ResponseHandler;
import com.wish.WishTaskManagement.TaskManagement.services.CommentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("")
    public ResponseEntity<Object> createComment(@Valid @RequestBody CommentRequestDTO commentRequestDTO){
        CommentResponseDTO commentResponseDTO = commentService.create(commentRequestDTO);
        return ResponseHandler.responseBuilder(HttpStatus.CREATED,commentResponseDTO);
    }
}
