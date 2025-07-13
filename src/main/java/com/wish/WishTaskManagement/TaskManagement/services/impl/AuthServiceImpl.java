package com.wish.WishTaskManagement.TaskManagement.services.impl;

import com.wish.WishTaskManagement.TaskManagement.config.jwt.JwtUtils;
import com.wish.WishTaskManagement.TaskManagement.dtos.requestDTO.SignInRequestDTO;
import com.wish.WishTaskManagement.TaskManagement.dtos.responseDTO.SignInResponseDTO;
import com.wish.WishTaskManagement.TaskManagement.mapper.SignInMapper;
import com.wish.WishTaskManagement.TaskManagement.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    @Override
    public SignInResponseDTO signin(SignInRequestDTO signInRequestDTO){
        Authentication authentication;
        authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signInRequestDTO.getEmail(),signInRequestDTO.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String accessToken = jwtUtils.generateAccessToken(userDetails);
        String refreshToken = jwtUtils.generateRefreshToken(userDetails);
        return SignInMapper.toDTO(accessToken,refreshToken);
    }
}
