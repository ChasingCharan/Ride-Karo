package com.example.RideKaro.contoller;

import com.example.RideKaro.Enum.Gender;
import com.example.RideKaro.dto.request.CustomerRequest;
import com.example.RideKaro.dto.response.CustomerResponse;
import com.example.RideKaro.service.CustomerService;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<Object> addCustomer(@RequestBody CustomerRequest customerRequest){
        CustomerResponse customerResponse = customerService.addCustomer(customerRequest);
        return new ResponseEntity<>(customerResponse, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Object> getCustomer(@RequestParam("email") String email){
        try{
            CustomerResponse customerResponse = customerService.getCustomer(email);
            return new ResponseEntity<>(customerResponse,HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/gender/{gender}/age/{age}")
    public List<CustomerResponse> getAllGenderAndAgeGreaterThan(@PathVariable("gender")Gender gender,
                                                                @PathVariable("age") int age){
        return customerService.getAllGenderAndAgeGreaterThan(gender,age);

    }
}
