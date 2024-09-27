package com.example.RideKaro.contoller;

import com.example.RideKaro.dto.request.BookingRequest;
import com.example.RideKaro.dto.response.BookingResponse;
import com.example.RideKaro.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/book")
@RequiredArgsConstructor
public class BookingController {

    public final BookingService bookingService;

    @PostMapping
    public ResponseEntity<Object> bookCab(@RequestParam(value = "coupon-applied", required = false) boolean couponApplied,
            @RequestBody BookingRequest bookingRequest){
        try {
            BookingResponse bookingResponse = bookingService.bookCab(couponApplied,bookingRequest);
            return new ResponseEntity<>(bookingResponse, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
