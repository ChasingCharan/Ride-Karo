package com.example.RideKaro.service;

import com.example.RideKaro.model.Coupon;
import com.example.RideKaro.repository.CouponRepository;
import com.example.RideKaro.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CouponService {
    private final CouponRepository couponRepository;

    public String addCoupon(String couponCode, int percentageDiscount) {
        Coupon coupon = Coupon.builder()
                .couponCode(couponCode)
                .percentageDiscount(percentageDiscount)
                .build();
        couponRepository.save(coupon);
        return "Coupon add!!!";
    }
}
