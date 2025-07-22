package com.wish.WishTaskManagement.TaskManagement.services;

import com.wish.WishTaskManagement.TaskManagement.dtos.UserActivityDTO.UserActivityCreateDTO;
import com.wish.WishTaskManagement.TaskManagement.dtos.UserActivityDTO.UserActivityResponseDTO;

import java.util.List;
import java.util.UUID;

public interface UserActivityService {

    List<UserActivityResponseDTO> getAllActivity(UUID id);

    UserActivityResponseDTO createActivity(UserActivityCreateDTO userActivityCreateDTO);
}
