package com.coditas.restaurantmanagementsystem.dto.response;

import lombok.*;

@Builder
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class OwnerRegistrationResponse {
    private UserResponseDto user;
    private CompanyResponseDto company;
}
