package com.coditas.restaurantmanagementsystem.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class RestaurantManagerRegistrationRequest {
    @NotNull
    private UserRequestDto user;
    @NotNull
    private RestaurantRequestDto restaurant;
}
