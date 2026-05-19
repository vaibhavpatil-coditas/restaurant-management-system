package com.coditas.restaurantmanagementsystem.service;

import com.coditas.restaurantmanagementsystem.dto.request.InvitationDto;
import jakarta.validation.Valid;

public interface AdminService {
    InvitationDto inviteRestaurantOwner(@Valid InvitationDto invitationDto);
}
