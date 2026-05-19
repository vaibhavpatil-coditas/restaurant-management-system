package com.coditas.restaurantmanagementsystem.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class RestaurantManagerRegistrationRequest {
    @NotNull(message = "Enter user credentials")
    private UserRequestDto user;
    @NotNull(message = "Enter restaurant details")
    private RestaurantRequestDto restaurant;
}
