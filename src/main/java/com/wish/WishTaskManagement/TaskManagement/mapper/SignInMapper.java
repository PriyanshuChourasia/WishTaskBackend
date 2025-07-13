package com.wish.WishTaskManagement.TaskManagement.mapper;

import com.wish.WishTaskManagement.TaskManagement.dtos.responseDTO.SignInResponseDTO;

public class SignInMapper {
    public static SignInResponseDTO toDTO(String accessToken, String refreshToken){
        SignInResponseDTO signInResponseDTO = new SignInResponseDTO();
        signInResponseDTO.setAccessToken(accessToken);
        signInResponseDTO.setRefreshToken(refreshToken);
        return signInResponseDTO;
    }
}
