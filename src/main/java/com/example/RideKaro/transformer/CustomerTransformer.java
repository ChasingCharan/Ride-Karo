package com.example.RideKaro.transformer;

import com.example.RideKaro.dto.request.CustomerRequest;
import com.example.RideKaro.dto.response.CustomerResponse;
import com.example.RideKaro.model.Customer;

public class CustomerTransformer {
    public static Customer customerRequestToCustomer(CustomerRequest customerRequest) {
        return Customer.builder()
                .name(customerRequest.getName())
                .age(customerRequest.getAge())
                .emailId(customerRequest.getEmail())
                .gender(customerRequest.getGender())
                .build();

    }

    public static CustomerResponse customeToCustomerResponse(Customer saveCustomer) {
        return CustomerResponse.builder()
                .name(saveCustomer.getName())
                .age(saveCustomer.getAge())
                .email(saveCustomer.getEmailId())
                .gender(saveCustomer.getGender())
                .build();
    }
}
