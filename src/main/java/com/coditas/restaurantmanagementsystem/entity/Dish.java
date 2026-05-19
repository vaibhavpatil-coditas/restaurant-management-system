package com.coditas.restaurantmanagementsystem.entity;

import com.coditas.restaurantmanagementsystem.enums.FoodCategory;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "dishes")
@Getter @Setter
@NoArgsConstructor
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private long price;

    @Enumerated(EnumType.STRING)
    private FoodCategory category;

    private String description;
    private int calories;
}
