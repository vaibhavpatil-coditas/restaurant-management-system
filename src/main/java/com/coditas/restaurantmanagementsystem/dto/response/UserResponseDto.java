package com.coditas.restaurantmanagementsystem.dto.response;

import com.coditas.restaurantmanagementsystem.enums.Role;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserResponseDto {
    private String username;
    private String name;
    private String email;
    private Role role;
}
