package com.example.RideKaro.service;

import com.example.RideKaro.Enum.Gender;
import com.example.RideKaro.dto.request.CustomerRequest;
import com.example.RideKaro.dto.response.CustomerResponse;
import com.example.RideKaro.exception.CustomerNotFoundException;
import com.example.RideKaro.model.Customer;
import com.example.RideKaro.repository.CustomerRepository;
import com.example.RideKaro.transformer.CustomerTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    public final CustomerRepository customerRepository;

    public CustomerResponse addCustomer(CustomerRequest customerRequest) {
        Customer customer = CustomerTransformer.customerRequestToCustomer(customerRequest);
        Customer saveCustomer = customerRepository.save(customer);
        return CustomerTransformer.customeToCustomerResponse(saveCustomer);
    }

    public CustomerResponse getCustomer(String email) throws CustomerNotFoundException {
        Customer checkCustomer = customerRepository.findByEmailId(email);
        if(checkCustomer == null){
            throw new CustomerNotFoundException("Customer with " +email+" not found");
        }
        return CustomerTransformer.customeToCustomerResponse(checkCustomer);
    }

    public List<CustomerResponse> getAllGenderAndAgeGreaterThan(Gender gender, int age) {
        List<Customer> customers = customerRepository.getAllGenderAndAgeGreaterThan(gender,age);
        List<CustomerResponse> customerResponses = new ArrayList<>();
        for(Customer customer : customers){
            customerResponses.add(CustomerTransformer.customeToCustomerResponse((customer)));
        }
        return customerResponses;
    }
}




