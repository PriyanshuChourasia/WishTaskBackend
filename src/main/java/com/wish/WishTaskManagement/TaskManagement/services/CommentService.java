package com.wish.WishTaskManagement.TaskManagement.services;

import com.wish.WishTaskManagement.TaskManagement.dtos.CommentDTO.CommentRequestDTO;
import com.wish.WishTaskManagement.TaskManagement.dtos.CommentDTO.CommentResponseDTO;

public interface CommentService {

    CommentResponseDTO create(CommentRequestDTO commentRequestDTO);
}
