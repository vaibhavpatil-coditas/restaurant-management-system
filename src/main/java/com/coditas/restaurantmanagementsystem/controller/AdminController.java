package com.coditas.restaurantmanagementsystem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/v1/admin")
@RequiredArgsConstructor
public class AdminController {

    @PostMapping("/invitation")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void inviteRestaurantOwner(){

    }
}
