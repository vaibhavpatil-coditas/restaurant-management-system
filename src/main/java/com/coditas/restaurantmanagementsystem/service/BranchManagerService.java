package com.coditas.restaurantmanagementsystem.service;

import com.coditas.restaurantmanagementsystem.dto.request.BranchManagerRegistrationRequest;
import com.coditas.restaurantmanagementsystem.dto.response.BranchManagerRegistrationResponse;
import jakarta.validation.Valid;

public interface BranchManagerService {
    BranchManagerRegistrationResponse register(@Valid BranchManagerRegistrationRequest request);
}
