package com.coditas.restaurantmanagementsystem.controller;

import com.coditas.restaurantmanagementsystem.constants.ApiPaths;
import com.coditas.restaurantmanagementsystem.dto.request.LoginRequest;
import com.coditas.restaurantmanagementsystem.dto.response.ApplicationResponse;
import com.coditas.restaurantmanagementsystem.dto.response.LoginResponse;
import com.coditas.restaurantmanagementsystem.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiPaths.Auth.BASE)
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping(ApiPaths.Auth.LOGIN)
    public ResponseEntity<ApplicationResponse<LoginResponse>> login(@Valid @RequestBody LoginRequest loginRequest){
        return ResponseEntity.ok(
                ApplicationResponse.<LoginResponse>builder()
                        .success(true)
                        .message("Login successful")
                        .data(authService.login(loginRequest))
                        .build());
    }
}
