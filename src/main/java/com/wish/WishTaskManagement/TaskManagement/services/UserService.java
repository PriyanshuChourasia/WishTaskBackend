package com.wish.WishTaskManagement.TaskManagement.services;

import com.wish.WishTaskManagement.TaskManagement.dtos.requestDTO.UserRequestDTO;
import com.wish.WishTaskManagement.TaskManagement.dtos.responseDTO.UserResponseDTO;

public interface UserService {
    UserResponseDTO create(UserRequestDTO userRequestDTO);
    UserResponseDTO userDetail(String token);
}
