package com.coditas.restaurantmanagementsystem.dto.request;

import com.coditas.restaurantmanagementsystem.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserRequestDto {
    @NotBlank(message = "Username should not be blank")
    private String username;
    @NotBlank(message = "Name should not be blank")
    private String name;
    @Email(message = "Email should be provided")
    private String email;
    @NotNull(message = "Role should be not null")
    private Role role;
    @NotBlank(message = "Password should be not blank")
    private String password;
}
