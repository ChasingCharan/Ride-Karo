package com.example.RideKaro.contoller;

import com.example.RideKaro.service.CouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/coupon")
@RequiredArgsConstructor
public class CouponController {
    private final CouponService couponService;

    @PostMapping
    public ResponseEntity<String> addCoupon(@RequestParam("code") String couponCode,
                                            @RequestParam("discount") int percentageDiscount){
        String response = couponService.addCoupon(couponCode,percentageDiscount);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }
}
