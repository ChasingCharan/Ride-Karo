package com.example.RideKaro.dto.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookingRequest {
    String pickup;
    String destination;
    double totalDistance;
    String customerEmail;
}
