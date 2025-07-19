package com.wish.WishTaskManagement.TaskManagement.services.impl;

import com.wish.WishTaskManagement.TaskManagement.dtos.UserTypeDTO.UserTypeCreateDTO;
import com.wish.WishTaskManagement.TaskManagement.dtos.UserTypeDTO.UserTypeResponseDTO;
import com.wish.WishTaskManagement.TaskManagement.entities.UserType;
import com.wish.WishTaskManagement.TaskManagement.exceptions.DataExistsValidation;
import com.wish.WishTaskManagement.TaskManagement.mapper.UserTypeMapper;
import com.wish.WishTaskManagement.TaskManagement.repositories.UserTypeRepository;
import com.wish.WishTaskManagement.TaskManagement.services.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTypeServiceImpl implements UserTypeService {

    @Autowired
    private UserTypeRepository userTypeRepository;

    @Override
    public List<UserTypeResponseDTO> getAll(){
        List<UserType> userTypes = userTypeRepository.findAll();
        List<UserTypeResponseDTO> userTypeResponseDTOS = userTypes.stream().map(userType -> UserTypeMapper.toDTO(userType)).toList();
        return userTypeResponseDTOS;
    }

    @Override
    public UserTypeResponseDTO create(UserTypeCreateDTO userTypeCreateDTO){
        if(userTypeRepository.existsByName(userTypeCreateDTO.getName())){
            throw new DataExistsValidation("User Type already exists");
        }
        UserType userType = userTypeRepository.save(UserTypeMapper.toModel(userTypeCreateDTO));
        return UserTypeMapper.toDTO(userType);
    }
}
