package com.wish.WishTaskManagement.TaskManagement.mapper;

import com.wish.WishTaskManagement.TaskManagement.dtos.UserTypeDTO.UserTypeCreateDTO;
import com.wish.WishTaskManagement.TaskManagement.dtos.UserTypeDTO.UserTypeResponseDTO;
import com.wish.WishTaskManagement.TaskManagement.entities.UserType;

public class UserTypeMapper {
    public static UserTypeResponseDTO toDTO(UserType userType){
        UserTypeResponseDTO userTypeResponseDTO = new UserTypeResponseDTO();
        userTypeResponseDTO.setId(userType.getId().toString());
        userTypeResponseDTO.setName(userType.getName());
        userTypeResponseDTO.setDescription(userType.getDescription());
        userTypeResponseDTO.setAlias(userType.getAlias());
        userTypeResponseDTO.setLevel(userType.getLevel());
        return userTypeResponseDTO;
    }

    public static UserType toModel(UserTypeCreateDTO userTypeCreateDTO){
        UserType userType = new UserType();
        userType.setName(userTypeCreateDTO.getName());
        userType.setAlias(userTypeCreateDTO.getAlias());
        userType.setDescription(userTypeCreateDTO.getDescription());
        userType.setLevel(userTypeCreateDTO.getLevel());
        return userType;
    }
}
