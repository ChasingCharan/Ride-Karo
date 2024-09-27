package com.example.RideKaro.dto.request;

import com.example.RideKaro.model.Cab;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class DriverRequest {
    String name;
    int age;
    String drivingLicense;
    long mobileNo;
    CabRequest cabRequest;
}
