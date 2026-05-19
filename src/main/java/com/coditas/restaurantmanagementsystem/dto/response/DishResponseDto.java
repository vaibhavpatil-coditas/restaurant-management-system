package com.coditas.restaurantmanagementsystem.dto.response;

import com.coditas.restaurantmanagementsystem.enums.FoodCategory;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DishResponseDto {
    private Long id;
    private String name;
    private long price;
    private FoodCategory category;
    private String description;
    private int calories;
}
