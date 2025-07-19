package com.wish.WishTaskManagement.TaskManagement.services;

import com.wish.WishTaskManagement.TaskManagement.dtos.UserTypeDTO.UserTypeCreateDTO;
import com.wish.WishTaskManagement.TaskManagement.dtos.UserTypeDTO.UserTypeResponseDTO;

import java.util.List;

public interface UserTypeService {
    List<UserTypeResponseDTO> getAll();
    UserTypeResponseDTO create(UserTypeCreateDTO userTypeCreateDTO);
}
