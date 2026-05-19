package com.coditas.restaurantmanagementsystem.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@NoArgsConstructor
public class CompanyRequestDto {
    @NotBlank
    private String companyName;
}
