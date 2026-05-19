package com.coditas.restaurantmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "dish_ingredients")
@Getter @Setter
@NoArgsConstructor
public class DishIngredients {

    @EmbeddedId
    private DishIngredientId dishIngredientId;

    @ManyToOne
    @JoinColumn(name = "dish_id")
    @MapsId("dishId")
    private Dish dish;

    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    @MapsId("ingredientId")
    private Ingredient ingredient;
}
