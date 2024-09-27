package com.example.RideKaro.dto.response;

import lombok.*;
import org.springframework.stereotype.Service;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class DriverResponse {
    String name;
    int age;
    long mobileNo;
    CabResponse cab;
}
