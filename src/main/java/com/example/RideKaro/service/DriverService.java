package com.example.RideKaro.service;

import com.example.RideKaro.dto.request.DriverRequest;
import com.example.RideKaro.dto.response.DriverResponse;
import com.example.RideKaro.model.Cab;
import com.example.RideKaro.model.Driver;
import com.example.RideKaro.repository.DriverRepository;
import com.example.RideKaro.transformer.CabTransformer;
import com.example.RideKaro.transformer.DriverTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DriverService {

    public final DriverRepository driverRepository;
    public String addDriverAndCab(DriverRequest driverRequest) {
        Driver driver = DriverTransformer.driverRequestToDriver(driverRequest);
        Cab cab = CabTransformer.cabRequestToCab(driverRequest.getCabRequest());
        driver.setCab(cab);
        cab.setDriver(driver);
        driverRepository.save(driver);
        return "Driver Registration Successfully";
    }

    public DriverResponse getDriver(long mobileNo) {
        Driver saveDriver = driverRepository.findByMobileNo(mobileNo);
        return DriverTransformer.driverToDriverResponse(saveDriver);
    }
}
