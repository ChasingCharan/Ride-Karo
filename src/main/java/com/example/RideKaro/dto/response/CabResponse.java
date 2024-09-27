package com.example.RideKaro.dto.response;

import com.example.RideKaro.Enum.CabType;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class CabResponse {
    String cabNumber;
    CabType cabType;
    double farePerKm;
    boolean booked;
}
