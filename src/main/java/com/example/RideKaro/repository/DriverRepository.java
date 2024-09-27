package com.example.RideKaro.repository;

import com.example.RideKaro.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver,Integer> {
    Driver findByMobileNo(long mobileNo);
}
