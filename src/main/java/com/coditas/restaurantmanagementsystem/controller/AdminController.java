package com.coditas.restaurantmanagementsystem.controller;

import com.coditas.restaurantmanagementsystem.constants.ApiPaths;
import com.coditas.restaurantmanagementsystem.dto.response.ApplicationResponse;
import com.coditas.restaurantmanagementsystem.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(ApiPaths.Admin.BASE)
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @PostMapping(ApiPaths.Admin.INVITATIONS)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<ApplicationResponse<>> inviteRestaurantOwner(){
        return null;
    }
}
