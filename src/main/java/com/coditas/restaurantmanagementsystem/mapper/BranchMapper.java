package com.coditas.restaurantmanagementsystem.mapper;

import com.coditas.restaurantmanagementsystem.dto.request.BranchRequestDto;
import com.coditas.restaurantmanagementsystem.dto.response.BranchResponseDto;
import com.coditas.restaurantmanagementsystem.entity.Branch;
import jakarta.validation.constraints.NotNull;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BranchMapper {

    Branch toBranch(@NotNull BranchRequestDto branch);

    BranchResponseDto toBranchResponseDto(Branch savedBranch);
}
