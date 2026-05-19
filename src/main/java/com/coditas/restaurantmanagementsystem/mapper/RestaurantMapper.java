package com.coditas.restaurantmanagementsystem.mapper;

import com.coditas.restaurantmanagementsystem.dto.request.RestaurantRequestDto;
import com.coditas.restaurantmanagementsystem.dto.response.RestaurantResponseDto;
import com.coditas.restaurantmanagementsystem.entity.Restaurant;
import jakarta.validation.constraints.NotNull;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RestaurantMapper {
    Restaurant toRestaurant(@NotNull RestaurantRequestDto restaurant);

    RestaurantResponseDto toRestaurantResponseDto(Restaurant savedRestaurant);
}
