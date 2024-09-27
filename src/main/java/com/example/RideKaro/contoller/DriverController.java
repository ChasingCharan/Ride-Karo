package com.example.RideKaro.contoller;

import com.example.RideKaro.dto.request.DriverRequest;
import com.example.RideKaro.dto.response.DriverResponse;
import com.example.RideKaro.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/driver")
@RequiredArgsConstructor
public class DriverController {

    public final DriverService driverService;

    @PostMapping
    public ResponseEntity<String> addDriverAndCab(@RequestBody DriverRequest driverRequest){
        String response = driverService.addDriverAndCab(driverRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Object> getDriver(@RequestParam("mobileNo") long mobileNo){
        DriverResponse driverResponse = driverService.getDriver(mobileNo);
        return new ResponseEntity<>(driverResponse,HttpStatus.CREATED);
    }
}
