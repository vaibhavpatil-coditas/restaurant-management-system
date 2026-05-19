package com.coditas.restaurantmanagementsystem.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class BranchManagerRegistrationRequest {
    @NotNull(message = "User details should be provided")
    private UserRequestDto user;
    @NotNull(message = "Branch details should be provided")
    private BranchRequestDto branch;
}
