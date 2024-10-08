package com.example.RideKaro.repository;

import com.example.RideKaro.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CouponRepository extends JpaRepository<Coupon,Integer> {

    @Query(value = "Select * from coupon order by rand() limit 1",nativeQuery = true)
    Optional<Coupon> getRandomCoupon();
}
