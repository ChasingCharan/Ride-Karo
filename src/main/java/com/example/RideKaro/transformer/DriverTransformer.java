package com.example.RideKaro.transformer;

import com.example.RideKaro.dto.request.DriverRequest;
import com.example.RideKaro.dto.response.DriverResponse;
import com.example.RideKaro.model.Driver;

public class DriverTransformer {
    public static Driver driverRequestToDriver(DriverRequest driverRequest) {
        return Driver.builder()
                .name(driverRequest.getName())
                .age(driverRequest.getAge())
                .drivingLicense(driverRequest.getDrivingLicense())
                .mobileNo(driverRequest.getMobileNo())
                .build();
    }

    public static DriverResponse driverToDriverResponse(Driver driver) {
        return DriverResponse.builder()
                .name(driver.getName())
                .age(driver.getAge())
                .mobileNo(driver.getMobileNo())
                .cab(CabTransformer.cabToCabResponse(driver.getCab()))
                .build();
    }
}
