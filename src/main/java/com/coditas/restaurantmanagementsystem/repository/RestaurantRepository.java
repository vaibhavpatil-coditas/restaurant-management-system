package com.coditas.restaurantmanagementsystem.repository;

import com.coditas.restaurantmanagementsystem.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
