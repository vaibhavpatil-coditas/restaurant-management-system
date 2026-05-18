package com.coditas.restaurantmanagementsystem.service;

import com.coditas.restaurantmanagementsystem.dto.request.EmailDetails;

public interface EmailService {

    String sendSimpleMail(EmailDetails details);
}
