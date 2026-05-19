package com.coditas.restaurantmanagementsystem.controller;

import com.coditas.restaurantmanagementsystem.constants.ApiPaths;
import com.coditas.restaurantmanagementsystem.dto.request.InvitationDto;
import com.coditas.restaurantmanagementsystem.dto.request.OwnerRegistrationRequest;
import com.coditas.restaurantmanagementsystem.dto.response.ApplicationResponse;
import com.coditas.restaurantmanagementsystem.dto.response.OwnerRegistrationResponse;
import com.coditas.restaurantmanagementsystem.service.RestaurantOwnerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping(ApiPaths.RestaurantOwner.BASE)
@RequiredArgsConstructor
public class RestaurantOwnerController {

    private final RestaurantOwnerService restaurantOwnerService;

    @PostMapping(ApiPaths.RestaurantOwner.REGISTER)
    public ResponseEntity<ApplicationResponse<OwnerRegistrationResponse>> register(@Valid @RequestBody OwnerRegistrationRequest ownerRegistrationRequest){
        return ResponseEntity.created(URI.create(""))
                .body(ApplicationResponse.<OwnerRegistrationResponse>builder()
                                .success(true)
                                .message("Restaurant owner registered successfully")
                                .data(restaurantOwnerService.register(ownerRegistrationRequest))
                                .build());
    }

    @PostMapping(ApiPaths.RestaurantOwner.INVITATIONS)
    @PreAuthorize("hasRole('ROLE_OWNER')")
    public ResponseEntity<ApplicationResponse<InvitationDto>> inviteManager(@Valid @RequestBody InvitationDto invitationDto){
        return ResponseEntity.ok(ApplicationResponse.<InvitationDto>builder()
                .success(true)
                .message("Invitation sent successfully")
                .data(restaurantOwnerService.inviteRestaurantManager(invitationDto))
                .build());
    }
}
