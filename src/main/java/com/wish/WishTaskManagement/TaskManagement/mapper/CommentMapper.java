package com.wish.WishTaskManagement.TaskManagement.mapper;

import com.wish.WishTaskManagement.TaskManagement.dtos.CommentDTO.CommentResponseDTO;
import com.wish.WishTaskManagement.TaskManagement.entities.Comment;

public class CommentMapper {
    public static CommentResponseDTO toDTO(Comment comment){
        CommentResponseDTO commentResponseDTO = new CommentResponseDTO();
        commentResponseDTO.setId(comment.getId().toString());
        commentResponseDTO.setText(comment.getText());
        return commentResponseDTO;
    }
}
