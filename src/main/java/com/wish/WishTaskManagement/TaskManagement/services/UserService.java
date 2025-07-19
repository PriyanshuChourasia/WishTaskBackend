package com.wish.WishTaskManagement.TaskManagement.services;

import com.wish.WishTaskManagement.TaskManagement.dtos.requestDTO.UserRequestDTO;
import com.wish.WishTaskManagement.TaskManagement.dtos.responseDTO.UserResponseDTO;

import java.util.List;

public interface UserService {
    List<UserResponseDTO> getAll();
    UserResponseDTO create(UserRequestDTO userRequestDTO);
    UserResponseDTO userDetail(String token);
}
