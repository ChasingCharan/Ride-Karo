package com.example.RideKaro.service;

import com.example.RideKaro.dto.request.BookingRequest;
import com.example.RideKaro.dto.response.BookingResponse;
import com.example.RideKaro.exception.CabNotFoundException;
import com.example.RideKaro.exception.CustomerNotFoundException;
import com.example.RideKaro.model.*;
import com.example.RideKaro.repository.*;
import com.example.RideKaro.transformer.BookingTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookingService {


    private final JavaMailSender javaMailSender;
    private final BookingRepository bookingRepository;
    private final CustomerRepository customerRepository;
    private final CabRepository cabRepository;
    private final DriverRepository driverRepository;
    private final CouponRepository couponRepository;


    public BookingResponse bookCab(boolean couponApplied,BookingRequest bookingRequest) {
        Customer customer = customerRepository.findByEmailId(bookingRequest.getCustomerEmail());
        if(ObjectUtils.isEmpty(customer)){
            throw  new CustomerNotFoundException("Invalid email Id");
        }

        Optional<Cab> optionalCab = cabRepository.getRandomAvailableCab();
        if(optionalCab.isEmpty()){
            throw new CabNotFoundException("Seems like all drivers are busy");
        }
        Cab cab = optionalCab.get();
        Driver driver = cab.getDriver();

        cab.setBooked(true);

        // booking entity
        Booking booking = BookingTransformer.bookingRequestToBooking(bookingRequest,cab);
        booking.setCustomer(customer);
        booking.setDriver(driver);
        Booking saveBooking = bookingRepository.save(booking);

        //add coupon

        if(couponApplied){
            Optional<Coupon> optionalCoupon = couponRepository.getRandomCoupon();

            Coupon randomCoupon = optionalCoupon.get();
            double totalAmount = saveBooking.getTotalFare();
            double discount = totalAmount - (totalAmount * randomCoupon.getPercentageDiscount())/100;
            saveBooking.setTotalFare(discount);
        }



        // set the remaining attributes

        customer.getBookings().add(saveBooking);
        driver.getBookings().add(saveBooking);

        customerRepository.save(customer);
        driverRepository.save(driver);

        sendMail(saveBooking);


        return BookingTransformer.bookingToBookingResponse(saveBooking);
    }

    private void sendMail(Booking booking) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("bllabllataxi@gmail.com");
        simpleMailMessage.setTo(booking.getCustomer().getEmailId());
        simpleMailMessage.setSubject("Booking conformation");
        simpleMailMessage.setText("Congrats! "+
                booking.getCustomer().getName() +
                " Your ride is conformed! " +" "+
                "Your Booking Id is: "+ booking.getBookingId());
        javaMailSender.send(simpleMailMessage);
    }
}
