package com.coditas.restaurantmanagementsystem.service;

import com.coditas.restaurantmanagementsystem.dto.request.LoginRequest;
import com.coditas.restaurantmanagementsystem.dto.response.LoginResponse;
import jakarta.validation.Valid;

public interface AuthService {
    LoginResponse login(@Valid LoginRequest loginRequest);
}
