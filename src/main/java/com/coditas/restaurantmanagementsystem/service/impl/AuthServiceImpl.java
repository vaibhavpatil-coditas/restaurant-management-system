package com.coditas.restaurantmanagementsystem.service.impl;

import com.coditas.restaurantmanagementsystem.dto.request.LoginRequest;
import com.coditas.restaurantmanagementsystem.dto.response.LoginResponse;
import com.coditas.restaurantmanagementsystem.security.jwt.JwtUtils;
import com.coditas.restaurantmanagementsystem.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        if(authentication.isAuthenticated()){
            authentication.
        }
        return null;
    }
}
