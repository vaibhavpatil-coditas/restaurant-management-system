package com.coditas.restaurantmanagementsystem.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class BranchManagerRegistrationRequest {
    @NotNull
    private UserRequestDto user;
    @NotNull
    private BranchRequestDto branch;
}
