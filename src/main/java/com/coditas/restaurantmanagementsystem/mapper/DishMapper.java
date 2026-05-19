package com.coditas.restaurantmanagementsystem.mapper;

import com.coditas.restaurantmanagementsystem.dto.DishRequestDto;
import com.coditas.restaurantmanagementsystem.entity.Dish;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DishMapper {
    Dish toDish(DishRequestDto dishRequestDto);
}
