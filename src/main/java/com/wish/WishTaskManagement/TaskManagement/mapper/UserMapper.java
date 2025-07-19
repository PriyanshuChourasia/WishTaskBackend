package com.wish.WishTaskManagement.TaskManagement.mapper;

import com.wish.WishTaskManagement.TaskManagement.dtos.UserTypeDTO.UserTypeResponseDTO;
import com.wish.WishTaskManagement.TaskManagement.dtos.responseDTO.UserResponseDTO;
import com.wish.WishTaskManagement.TaskManagement.entities.User;
import com.wish.WishTaskManagement.TaskManagement.entities.UserType;

public class UserMapper {
    public static UserResponseDTO toDTO(User user){
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setId(user.getId().toString());
        userResponseDTO.setName(user.getName());
        userResponseDTO.setEmail(user.getEmail());
        userResponseDTO.setProfilePictureUrl(user.getProfilePictureUrl());

//        UserType
        UserType userType = user.getUserType();
        if(userType != null){
            UserTypeResponseDTO userTypeResponseDTO = new UserTypeResponseDTO();
            userTypeResponseDTO.setName(userType.getName());
            userTypeResponseDTO.setLevel(userType.getLevel());
            userResponseDTO.setUserType(userTypeResponseDTO);
        }

        return userResponseDTO;
    }
}
