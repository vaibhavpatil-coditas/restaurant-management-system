package com.coditas.restaurantmanagementsystem.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Builder
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class OwnerRegistrationRequest {
    @NotNull(message = "Enter user details")
    private UserRequestDto user;
    @NotNull(message = "Enter Company details")
    private CompanyRequestDto company;
}
