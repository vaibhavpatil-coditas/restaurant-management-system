package com.coditas.restaurantmanagementsystem.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter @Setter
public class RestaurantManagerRegistrationResponse {
    private UserResponseDto user;
    private RestaurantResponseDto restaurant;
}
