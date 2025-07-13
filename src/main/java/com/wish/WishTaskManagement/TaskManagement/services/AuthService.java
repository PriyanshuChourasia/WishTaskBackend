package com.wish.WishTaskManagement.TaskManagement.services;

import com.wish.WishTaskManagement.TaskManagement.dtos.requestDTO.SignInRequestDTO;
import com.wish.WishTaskManagement.TaskManagement.dtos.responseDTO.SignInResponseDTO;

public interface AuthService {
    SignInResponseDTO signin(SignInRequestDTO signInRequestDTO);
}
