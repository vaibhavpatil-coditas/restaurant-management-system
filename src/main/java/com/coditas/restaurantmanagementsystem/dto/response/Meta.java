package com.coditas.restaurantmanagementsystem.dto.response;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Meta {
    private String requestId;
    private LocalDateTime timestamp;
    private int status;
}
