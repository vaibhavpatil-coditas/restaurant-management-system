package com.coditas.restaurantmanagementsystem.dto;

import com.coditas.restaurantmanagementsystem.enums.FoodCategory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DishRequestDto {
    @NotBlank
    private String name;
    @Positive
    private long price;
    @NotNull
    private FoodCategory category;
    @NotBlank
    private String description;
    @Positive
    private int calories;
}
