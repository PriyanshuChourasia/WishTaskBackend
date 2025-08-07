package com.wish.WishTaskManagement.TaskManagement.services.impl;

import com.wish.WishTaskManagement.TaskManagement.dtos.CommentDTO.CommentRequestDTO;
import com.wish.WishTaskManagement.TaskManagement.dtos.CommentDTO.CommentResponseDTO;
import com.wish.WishTaskManagement.TaskManagement.entities.Comment;
import com.wish.WishTaskManagement.TaskManagement.entities.Task;
import com.wish.WishTaskManagement.TaskManagement.entities.User;
import com.wish.WishTaskManagement.TaskManagement.exceptions.DataNotExistsValidation;
import com.wish.WishTaskManagement.TaskManagement.mapper.CommentMapper;
import com.wish.WishTaskManagement.TaskManagement.repositories.CommentRepository;
import com.wish.WishTaskManagement.TaskManagement.repositories.TaskRepository;
import com.wish.WishTaskManagement.TaskManagement.repositories.UserRepository;
import com.wish.WishTaskManagement.TaskManagement.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public CommentResponseDTO create(CommentRequestDTO commentRequestDTO){
        User user = userRepository.findById(UUID.fromString(commentRequestDTO.getUserId())).orElseThrow(()-> new DataNotExistsValidation("User doesn't exists"));
        Task task = taskRepository.findById(UUID.fromString(commentRequestDTO.getTaskId())).orElseThrow(()-> new DataNotExistsValidation("Task doesn't exists"));
        Comment comment = new Comment();
        comment.setUser(user);
        comment.setTask(task);
        comment.setText(commentRequestDTO.getText());
        Comment createdComment = commentRepository.save(comment);
        return CommentMapper.toDTO(createdComment);
    }
}
