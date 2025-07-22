package com.wish.WishTaskManagement.TaskManagement.mapper;

import com.wish.WishTaskManagement.TaskManagement.dtos.UserActivityDTO.UserActivityResponseDTO;
import com.wish.WishTaskManagement.TaskManagement.entities.UserActivity;

public class UserActivityMapper {
    public static UserActivityResponseDTO toDTO(UserActivity userActivity){
        UserActivityResponseDTO userActivityResponseDTO = new UserActivityResponseDTO();
        userActivityResponseDTO.setId(userActivity.getId().toString());
        userActivityResponseDTO.setName(userActivity.getName());
        userActivityResponseDTO.setTopic(userActivity.getTopic());
        userActivityResponseDTO.setDescription(userActivity.getDescription());
        userActivityResponseDTO.setStatus(userActivity.getStatus().toString());
        userActivityResponseDTO.setStartTime(userActivity.getStartTime());
        userActivityResponseDTO.setEndTime(userActivity.getEndTime());
        userActivityResponseDTO.setCreatedAt(userActivity.getCreatedAt());
        return userActivityResponseDTO;
    }
}
