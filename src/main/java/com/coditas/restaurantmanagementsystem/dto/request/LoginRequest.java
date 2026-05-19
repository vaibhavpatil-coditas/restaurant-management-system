package com.coditas.restaurantmanagementsystem.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class LoginRequest {
    @NotBlank(message = "Enter username")
    private String username;
    @NotBlank(message = "Enter password")
    private String password;
}
