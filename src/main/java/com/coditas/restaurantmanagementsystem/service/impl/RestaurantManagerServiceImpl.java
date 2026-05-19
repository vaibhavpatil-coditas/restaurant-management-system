package com.coditas.restaurantmanagementsystem.service.impl;

import com.coditas.restaurantmanagementsystem.constants.ApiPaths;
import com.coditas.restaurantmanagementsystem.dto.request.EmailDetails;
import com.coditas.restaurantmanagementsystem.dto.request.InvitationDto;
import com.coditas.restaurantmanagementsystem.dto.request.RestaurantManagerRegistrationRequest;
import com.coditas.restaurantmanagementsystem.dto.response.RestaurantManagerRegistrationResponse;
import com.coditas.restaurantmanagementsystem.entity.Restaurant;
import com.coditas.restaurantmanagementsystem.entity.User;
import com.coditas.restaurantmanagementsystem.enums.Role;
import com.coditas.restaurantmanagementsystem.mapper.RestaurantMapper;
import com.coditas.restaurantmanagementsystem.mapper.UserMapper;
import com.coditas.restaurantmanagementsystem.repository.RestaurantRepository;
import com.coditas.restaurantmanagementsystem.repository.UserRepository;
import com.coditas.restaurantmanagementsystem.service.EmailService;
import com.coditas.restaurantmanagementsystem.service.RestaurantManagerService;
import jakarta.validation.constraints.Email;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RestaurantManagerServiceImpl implements RestaurantManagerService {

    private final UserMapper userMapper;
    private final RestaurantMapper restaurantMapper;
    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;
    private final PasswordEncoder passwordEncoder;
    private final EmailService emailService;

    @Override
    public RestaurantManagerRegistrationResponse registerRestaurantManager(RestaurantManagerRegistrationRequest request) {
        User user = userMapper.toUser(request.getUser());
        user.setRole(Role.RESTAURANT_MANAGER);
        if(user.getUsername().isEmpty())
            user.setUsername(user.getEmail().split("@")[0]);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Restaurant restaurant = restaurantMapper.toRestaurant(request.getRestaurant());
        restaurant.setUser(user);
        User savedUser = userRepository.save(user);
        Restaurant savedRestaurant = restaurantRepository.save(restaurant);
        return RestaurantManagerRegistrationResponse.builder()
                .user(userMapper.toUserResponseDto(savedUser))
                .restaurant(restaurantMapper.toRestaurantResponseDto(savedRestaurant))
                .build();
    }

    @Override
    public InvitationDto inviteBranchManager(InvitationDto invitationDto) {
        String subject = "Complete Your Branch Registration";

        String body = """
                        Dear %s,

                        You have been invited by the restaurant manager to register yourself and your branch on our platform.

                        Please click the link below to complete your registration:

                        %s

                        During the registration process, you will be able to create your manager profile and add your branch details.

                        If you face any issues while registering, please contact us.

                        We look forward to welcoming you onboard.

                        Best regards,
                        %s
                        """.formatted(invitationDto.getEmail().split("\\.")[0],
                ApiPaths.BranchManager.BASE+ApiPaths.BranchManager.REGISTER,
                "Company Name");

        EmailDetails emailDetails = EmailDetails.builder()
                .recipient(invitationDto.getEmail())
                .msgBody(body)
                .subject(subject)
                .build();

        emailService.sendSimpleMail(emailDetails);
        return InvitationDto.builder()
                .email(invitationDto.getEmail())
                .build();
    }
}
