package com.coditas.restaurantmanagementsystem.controller;

import com.coditas.restaurantmanagementsystem.constants.ApiPaths;
import com.coditas.restaurantmanagementsystem.dto.request.InvitationDto;
import com.coditas.restaurantmanagementsystem.dto.request.RestaurantManagerRegistrationRequest;
import com.coditas.restaurantmanagementsystem.dto.response.ApplicationResponse;
import com.coditas.restaurantmanagementsystem.dto.response.RestaurantManagerRegistrationResponse;
import com.coditas.restaurantmanagementsystem.service.RestaurantManagerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping(ApiPaths.RestaurantManager.BASE)
@RequiredArgsConstructor
public class RestaurantManagerController {

    private final RestaurantManagerService restaurantManagerService;

    @PostMapping(ApiPaths.RestaurantManager.REGISTER)
    public ResponseEntity<ApplicationResponse<RestaurantManagerRegistrationResponse>> registerRestaurantManager(@Valid @RequestBody RestaurantManagerRegistrationRequest request){
        return ResponseEntity.created(URI.create(ApiPaths.RestaurantManager.BASE+ApiPaths.RestaurantManager.REGISTER))
                .body(ApplicationResponse.<RestaurantManagerRegistrationResponse>builder()
                        .success(true)
                        .message("Restaurant manager registered successfully")
                        .data(restaurantManagerService.registerRestaurantManager(request))
                        .build());
    }

    @PostMapping(ApiPaths.RestaurantManager.INVITATIONS)
    public ResponseEntity<ApplicationResponse<InvitationDto>> inviteBranchManager(@Valid @RequestBody InvitationDto invitationDto){
        return ResponseEntity.ok(ApplicationResponse.<InvitationDto>builder()
                .success(true)
                .message("Invitation sent to branch manager")
                .data(restaurantManagerService.inviteBranchManager(invitationDto))
                .build());
    }
}
