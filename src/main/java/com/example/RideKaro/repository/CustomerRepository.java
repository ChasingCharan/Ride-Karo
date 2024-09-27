package com.example.RideKaro.repository;

import com.example.RideKaro.Enum.Gender;
import com.example.RideKaro.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Customer findByEmailId(String email);
    @Query(value = "select c from Customer c where c.gender = :gender and c.age >= :age")
    List<Customer> getAllGenderAndAgeGreaterThan(Gender gender, int age);
}


