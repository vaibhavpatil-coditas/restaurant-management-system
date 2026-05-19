package com.coditas.restaurantmanagementsystem.service.impl;

import com.coditas.restaurantmanagementsystem.dto.request.LoginRequest;
import com.coditas.restaurantmanagementsystem.dto.response.LoginResponse;
import com.coditas.restaurantmanagementsystem.security.jwt.JwtUtils;
import com.coditas.restaurantmanagementsystem.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        LoginResponse loginResponse = null;
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        UserDetails user = (UserDetails) authentication.getPrincipal();
        log.info("{}", user.getUsername());
        if(user != null) loginResponse = LoginResponse.builder()
                .token(jwtUtils.generateToken(user))
                .build();
        return loginResponse;
    }
}
