package com.example.RideKaro.dto.request;

import com.example.RideKaro.Enum.CabType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class CabRequest {
    String cabNumber;
    CabType cabType;
    double farePerKm;
    boolean booked;
}
