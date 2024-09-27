package com.example.RideKaro.transformer;

import com.example.RideKaro.Enum.BookingStatus;
import com.example.RideKaro.dto.request.BookingRequest;
import com.example.RideKaro.dto.response.BookingResponse;
import com.example.RideKaro.model.Booking;
import com.example.RideKaro.model.Cab;

import java.util.UUID;

public class BookingTransformer {
    public static Booking bookingRequestToBooking(BookingRequest bookingRequest, Cab cab) {
        return Booking.builder()
                .bookingId(String.valueOf(UUID.randomUUID()))
                .pickup(bookingRequest.getPickup())
                .bookingStatus(BookingStatus.CONFORMED)
                .destination(bookingRequest.getDestination())
                .totalDistance(bookingRequest.getTotalDistance())
                .totalFare(bookingRequest.getTotalDistance()*cab.getFarePerKm())
                .build();
    }

    public static BookingResponse bookingToBookingResponse(Booking booking) {
        return BookingResponse.builder()
                .bookingId(booking.getBookingId())
                .pickUp(booking.getPickup())
                .destination(booking.getDestination())
                .bookingStatus(booking.getBookingStatus())
                .totalDistance(booking.getTotalDistance())
                .totalFare(booking.getTotalFare())
                .customerResponse(CustomerTransformer.customeToCustomerResponse(booking.getCustomer()))
                .driverResponse(DriverTransformer.driverToDriverResponse(booking.getDriver()))
                .build();
    }
}
