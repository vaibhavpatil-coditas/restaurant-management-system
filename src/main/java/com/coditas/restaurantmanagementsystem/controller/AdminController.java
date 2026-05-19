package com.coditas.restaurantmanagementsystem.controller;

import com.coditas.restaurantmanagementsystem.constants.ApiPaths;
import com.coditas.restaurantmanagementsystem.dto.request.InvitationDto;
import com.coditas.restaurantmanagementsystem.dto.response.ApplicationResponse;
import com.coditas.restaurantmanagementsystem.service.AdminService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiPaths.Admin.BASE)
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @PostMapping(ApiPaths.Admin.INVITATIONS)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<ApplicationResponse<InvitationDto>> inviteRestaurantOwner(@Valid @RequestBody InvitationDto invitationDto){
        return ResponseEntity.ok(
                ApplicationResponse.<InvitationDto>builder()
                        .success(true)
                        .message("Invitation sent successfully")
                        .data(adminService.inviteRestaurantOwner(invitationDto))
                        .build()
        );
    }
}
