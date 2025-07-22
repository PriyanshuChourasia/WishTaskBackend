package com.wish.WishTaskManagement.TaskManagement.services;

import com.wish.WishTaskManagement.TaskManagement.dtos.requestDTO.UserRequestDTO;
import com.wish.WishTaskManagement.TaskManagement.dtos.requestDTO.UserUpdateRequestDTO;
import com.wish.WishTaskManagement.TaskManagement.dtos.requestDTO.UserUpdateRoleDTO;
import com.wish.WishTaskManagement.TaskManagement.dtos.responseDTO.UserResponseDTO;

import java.util.List;
import java.util.UUID;

public interface UserService {
    List<UserResponseDTO> getAll();
    UserResponseDTO create(UserRequestDTO userRequestDTO);
    UserResponseDTO userDetail(String token);
    UserResponseDTO update(UUID id, UserUpdateRequestDTO userUpdateRequestDTO);
    void destroy(UUID id);

    void updateRole(UUID id, UserUpdateRoleDTO userUpdateRoleDTO);
}
