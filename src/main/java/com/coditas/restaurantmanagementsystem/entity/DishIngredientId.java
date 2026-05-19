package com.coditas.restaurantmanagementsystem.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class DishIngredientId implements Serializable {
    private Long dishId;
    private Long ingredientId;
}
