package com.coditas.restaurantmanagementsystem.mapper;

import com.coditas.restaurantmanagementsystem.dto.request.CompanyRequestDto;
import com.coditas.restaurantmanagementsystem.dto.response.CompanyResponseDto;
import com.coditas.restaurantmanagementsystem.entity.Company;
import jakarta.validation.constraints.NotNull;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompanyMapper {
    Company toCompany(@NotNull CompanyRequestDto company);

    CompanyResponseDto toCompanyResponseDto(Company savedCompany);
}
