package com.wish.WishTaskManagement.TaskManagement.services.impl;


import com.wish.WishTaskManagement.TaskManagement.dtos.UserActivityDTO.UserActivityCreateDTO;
import com.wish.WishTaskManagement.TaskManagement.dtos.UserActivityDTO.UserActivityResponseDTO;
import com.wish.WishTaskManagement.TaskManagement.entities.User;
import com.wish.WishTaskManagement.TaskManagement.entities.UserActivity;
import com.wish.WishTaskManagement.TaskManagement.exceptions.DataNotExistsValidation;
import com.wish.WishTaskManagement.TaskManagement.mapper.UserActivityMapper;
import com.wish.WishTaskManagement.TaskManagement.repositories.UserActivityRepository;
import com.wish.WishTaskManagement.TaskManagement.repositories.UserRepository;
import com.wish.WishTaskManagement.TaskManagement.services.UserActivityService;
import com.wish.WishTaskManagement.TaskManagement.utils.enums.WorkStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserActivityServiceImpl implements UserActivityService {

    @Autowired
    private UserActivityRepository userActivityRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserActivityResponseDTO> getAllActivity(UUID id){
        List<UserActivity> userActivities = userActivityRepository.findByUserId(id);
        List<UserActivityResponseDTO> userActivityResponseDTOS = userActivities.stream().map(userActivity -> UserActivityMapper.toDTO(userActivity)).toList();
        return userActivityResponseDTOS;
    }

    @Override
    public UserActivityResponseDTO createActivity(UserActivityCreateDTO userActivityCreateDTO){
        UserActivity userActivity = new UserActivity();
        userActivity.setName(userActivityCreateDTO.getName());
        userActivity.setDescription(userActivityCreateDTO.getDescription());
        userActivity.setStatus(WorkStatusEnum.valueOf(userActivityCreateDTO.getStatus()));
        userActivity.setTopic(userActivityCreateDTO.getTopic());
        userActivity.setStartTime(userActivityCreateDTO.getStartTime());
        userActivity.setEndTime(userActivityCreateDTO.getEndTime());
        if(userActivityCreateDTO.getUser_id() != null){
            User user = userRepository.findById(UUID.fromString(userActivityCreateDTO.getUser_id())).orElseThrow(()-> new DataNotExistsValidation("User doesn't exists"));
            userActivity.setUser(user);
        }
        UserActivity createUserActivity = userActivityRepository.save(userActivity);
        return UserActivityMapper.toDTO(createUserActivity);
    }
}
