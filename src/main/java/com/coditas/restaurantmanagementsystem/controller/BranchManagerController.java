package com.coditas.restaurantmanagementsystem.controller;

import com.coditas.restaurantmanagementsystem.constants.ApiPaths;
import com.coditas.restaurantmanagementsystem.dto.request.BranchManagerRegistrationRequest;
import com.coditas.restaurantmanagementsystem.dto.response.ApplicationResponse;
import com.coditas.restaurantmanagementsystem.dto.response.BranchManagerRegistrationResponse;
import com.coditas.restaurantmanagementsystem.service.BranchManagerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping(ApiPaths.BranchManager.BASE)
@RequiredArgsConstructor
public class BranchManagerController {

    private final BranchManagerService branchManagerService;

    @PostMapping(ApiPaths.BranchManager.REGISTER)
    public ResponseEntity<ApplicationResponse<BranchManagerRegistrationResponse>> register(@Valid @RequestBody BranchManagerRegistrationRequest request){
        return ResponseEntity.created(URI.create(ApiPaths.BranchManager.BASE+ApiPaths.BranchManager.REGISTER)).body(
                ApplicationResponse.<BranchManagerRegistrationResponse>builder()
                        .success(true)
                        .message("Branch manager registered successfully")
                        .data(branchManagerService.register(request))
                        .build()
        );
    }
}
