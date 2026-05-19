package com.coditas.restaurantmanagementsystem.dto.request;

import com.coditas.restaurantmanagementsystem.enums.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserRequestDto {
    @NotBlank
    private String username;
    @NotBlank
    private String name;
    @NotBlank
    private String email;
    @NotNull
    private Role role;
    @NotBlank
    private String password;
}
