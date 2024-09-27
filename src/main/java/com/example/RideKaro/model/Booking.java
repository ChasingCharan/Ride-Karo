package com.example.RideKaro.model;


import com.example.RideKaro.Enum.BookingStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String bookingId;
    String destination;
    String pickup;

    @Enumerated(EnumType.STRING)
    BookingStatus bookingStatus;

    double totalDistance;
    double totalFare;

    @CreationTimestamp
    Date bookedDate;

    @ManyToOne
    @JoinColumn
    Customer customer;

    @ManyToOne
    @JoinColumn
    Driver driver;


}
