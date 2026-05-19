package com.coditas.restaurantmanagementsystem.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@NoArgsConstructor
public class RestaurantResponseDto {
    private String name;
    private UserResponseDto user;
}
