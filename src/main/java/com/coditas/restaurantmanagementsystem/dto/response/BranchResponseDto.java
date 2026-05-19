package com.coditas.restaurantmanagementsystem.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BranchResponseDto {
    private UserResponseDto branchManager;
    private String location;
}
