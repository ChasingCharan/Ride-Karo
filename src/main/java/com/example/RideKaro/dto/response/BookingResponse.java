package com.example.RideKaro.dto.response;

import com.example.RideKaro.Enum.BookingStatus;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BookingResponse {
    String bookingId;
    String pickUp;
    String destination;
    BookingStatus bookingStatus;
    double totalDistance;
    double totalFare;
    CustomerResponse customerResponse;
    DriverResponse driverResponse;
}
