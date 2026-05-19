package com.coditas.restaurantmanagementsystem.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class RestaurantRequestDto {
    @NotBlank(message = "Name cannot be blank")
    private String name;
}
