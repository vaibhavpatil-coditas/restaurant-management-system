package com.coditas.restaurantmanagementsystem.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Builder
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class OwnerRegistrationRequest {
    @NotNull
    private UserRequestDto user;
    @NotNull
    private CompanyRequestDto company;
}
