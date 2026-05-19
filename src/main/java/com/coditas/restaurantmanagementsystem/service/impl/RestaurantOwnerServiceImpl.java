package com.coditas.restaurantmanagementsystem.service.impl;

import com.coditas.restaurantmanagementsystem.constants.ApiPaths;
import com.coditas.restaurantmanagementsystem.dto.request.EmailDetails;
import com.coditas.restaurantmanagementsystem.dto.request.InvitationDto;
import com.coditas.restaurantmanagementsystem.dto.request.OwnerRegistrationRequest;
import com.coditas.restaurantmanagementsystem.dto.response.OwnerRegistrationResponse;
import com.coditas.restaurantmanagementsystem.entity.Company;
import com.coditas.restaurantmanagementsystem.entity.User;
import com.coditas.restaurantmanagementsystem.enums.Role;
import com.coditas.restaurantmanagementsystem.mapper.CompanyMapper;
import com.coditas.restaurantmanagementsystem.mapper.UserMapper;
import com.coditas.restaurantmanagementsystem.repository.CompanyRepository;
import com.coditas.restaurantmanagementsystem.repository.UserRepository;
import com.coditas.restaurantmanagementsystem.service.RestaurantOwnerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RestaurantOwnerServiceImpl implements RestaurantOwnerService {

    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;
    private final UserMapper userMapper;
    private final CompanyMapper companyMapper;
    private final PasswordEncoder passwordEncoder;
    private final EmailServiceImpl emailService;

    @Override
    public OwnerRegistrationResponse register(OwnerRegistrationRequest ownerRegistrationRequest) {
        User user = userMapper.toUser(ownerRegistrationRequest.getUser());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.OWNER);
        if(user.getUsername()==null || user.getUsername().isEmpty())
            user.setUsername(user.getEmail());
        User savedUser = userRepository.save(user);

        Company company = companyMapper.toCompany(ownerRegistrationRequest.getCompany());
        company.setOwner(savedUser);
        Company savedCompany = companyRepository.save(company);

        return OwnerRegistrationResponse.builder()
                .user(userMapper.toUserResponseDto(savedUser))
                .company(companyMapper.toCompanyResponseDto(savedCompany))
                .build();
    }

    @Override
    public InvitationDto inviteRestaurantManager(InvitationDto invitationDto) {
        String subject = "Complete Your Restaurant Registration";

        String body = """
                        Dear %s,

                        You have been invited by the restaurant owner to register yourself and your restaurant on our platform.

                        Please click the link below to complete your registration:

                        %s

                        During the registration process, you will be able to create your manager profile and add your restaurant details.

                        If you face any issues while registering, please contact us.

                        We look forward to welcoming you onboard.

                        Best regards,
                        %s
                        """.formatted(invitationDto.getEmail().split("\\.")[0],
                ApiPaths.RestaurantManager.BASE+ApiPaths.RestaurantOwner.REGISTER,
                "Company Name"); //I am not able to do it right now

        EmailDetails emailDetails = EmailDetails.builder()
                .recipient(invitationDto.getEmail())
                .msgBody(body)
                .subject(subject)
                .build();
        emailService.sendSimpleMail(emailDetails);
        return InvitationDto.builder().email(invitationDto.getEmail()).build();
    }
}
