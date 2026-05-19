package com.coditas.restaurantmanagementsystem.repository;

import com.coditas.restaurantmanagementsystem.entity.Company;
import com.coditas.restaurantmanagementsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    Company findByOwner(User user);
}
