package com.coditas.restaurantmanagementsystem.mapper;

import com.coditas.restaurantmanagementsystem.dto.request.UserRequestDto;
import com.coditas.restaurantmanagementsystem.dto.response.UserResponseDto;
import com.coditas.restaurantmanagementsystem.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserRequestDto userRequestDto);
    UserResponseDto toUserResponseDto(User user);
}
