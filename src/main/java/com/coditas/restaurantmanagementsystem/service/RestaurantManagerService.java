package com.coditas.restaurantmanagementsystem.service;

import com.coditas.restaurantmanagementsystem.dto.request.InvitationDto;
import com.coditas.restaurantmanagementsystem.dto.request.RestaurantManagerRegistrationRequest;
import com.coditas.restaurantmanagementsystem.dto.response.RestaurantManagerRegistrationResponse;
import jakarta.validation.Valid;

public interface RestaurantManagerService {
    RestaurantManagerRegistrationResponse registerRestaurantManager(@Valid RestaurantManagerRegistrationRequest request);

    InvitationDto inviteBranchManager(@Valid InvitationDto invitationDto);
}
