package com.coditas.restaurantmanagementsystem.service.impl;

import com.coditas.restaurantmanagementsystem.constants.ApiPaths;
import com.coditas.restaurantmanagementsystem.dto.request.EmailDetails;
import com.coditas.restaurantmanagementsystem.dto.request.InvitationDto;
import com.coditas.restaurantmanagementsystem.service.AdminService;
import com.coditas.restaurantmanagementsystem.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final EmailService emailService;

    @Override
    public InvitationDto inviteRestaurantOwner(InvitationDto invitationDto) {
        EmailDetails emailDetails = EmailDetails.builder()
                .recipient(invitationDto.getEmail())
                .msgBody(ApiPaths.RestaurantOwner.BASE+ApiPaths.RestaurantOwner.REGISTER)
                .subject("Invitation")
                .build();
        emailService.sendSimpleMail(emailDetails);
        return InvitationDto.builder().email(invitationDto.getEmail()).build();
    }
}
