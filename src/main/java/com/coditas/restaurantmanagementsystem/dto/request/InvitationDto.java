package com.coditas.restaurantmanagementsystem.dto.request;

import jakarta.validation.constraints.Email;
import lombok.*;

@Builder
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class InvitationDto {
    @Email(message = "Enter valid email")
    private String email;
}
