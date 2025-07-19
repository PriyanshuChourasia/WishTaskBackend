package com.wish.WishTaskManagement.TaskManagement.services.impl;

import com.wish.WishTaskManagement.TaskManagement.config.jwt.JwtUtils;
import com.wish.WishTaskManagement.TaskManagement.dtos.requestDTO.UserRequestDTO;
import com.wish.WishTaskManagement.TaskManagement.dtos.responseDTO.UserResponseDTO;
import com.wish.WishTaskManagement.TaskManagement.entities.User;
import com.wish.WishTaskManagement.TaskManagement.entities.UserType;
import com.wish.WishTaskManagement.TaskManagement.exceptions.DataExistsValidation;
import com.wish.WishTaskManagement.TaskManagement.exceptions.DataNotExistsValidation;
import com.wish.WishTaskManagement.TaskManagement.mapper.UserMapper;
import com.wish.WishTaskManagement.TaskManagement.repositories.UserRepository;
import com.wish.WishTaskManagement.TaskManagement.repositories.UserTypeRepository;
import com.wish.WishTaskManagement.TaskManagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MyUserDetailServiceImpl myUserDetailService;

    @Autowired
    private UserTypeRepository userTypeRepository;

    @Autowired
    private JwtUtils jwtUtils;

    @Override
    public List<UserResponseDTO> getAll(){
        List<User> users = userRepository.findAll();
        List<UserResponseDTO> userResponseDTOS = users.stream().map(user -> UserMapper.toDTO(user)).toList();
        return userResponseDTOS;
    }


    @Override
    public UserResponseDTO create(UserRequestDTO userRequestDTO){
        if(userRepository.existsByEmail(userRequestDTO.getEmail())){
            throw new DataExistsValidation("User already exists");
        }
        UserType userType = userTypeRepository.findById(userRequestDTO.getUserType()).orElseThrow(()-> new DataNotExistsValidation("User type doesn't exists"));

        User user = new User();
        user.setName(userRequestDTO.getName());
        user.setEmail(userRequestDTO.getEmail());
        user.setUserType(userType);
        String encodedPassword = passwordEncoder.encode(userRequestDTO.getPassword());
        user.setPassword(encodedPassword);
        User createUser = userRepository.save(user);
        return UserMapper.toDTO(createUser);
    }

    @Override
    public UserResponseDTO userDetail(String token){
        String username = jwtUtils.getUsernameFromJwt(token);
        User user = userRepository.findByEmail(username);
        UserResponseDTO userResponseDTO = UserMapper.toDTO(user);
        return  userResponseDTO;
    }
}
