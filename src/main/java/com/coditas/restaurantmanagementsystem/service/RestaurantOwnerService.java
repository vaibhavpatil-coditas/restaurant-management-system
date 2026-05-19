package com.coditas.restaurantmanagementsystem.service;

import com.coditas.restaurantmanagementsystem.dto.request.InvitationDto;
import com.coditas.restaurantmanagementsystem.dto.request.OwnerRegistrationRequest;
import com.coditas.restaurantmanagementsystem.dto.response.OwnerRegistrationResponse;
import jakarta.validation.Valid;

public interface RestaurantOwnerService {
    OwnerRegistrationResponse register(@Valid OwnerRegistrationRequest ownerRegistrationRequest);

    InvitationDto inviteRestaurantManager(@Valid InvitationDto invitationDto);
}
