package com.example.RideKaro.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Entity

public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    String name;

    int age;

    @Column(unique = true,nullable = false)
    String drivingLicense;

    @Column(unique = true, nullable = false)
    long mobileNo;

    @OneToOne(mappedBy = "driver", cascade = CascadeType.ALL)
    Cab cab;

    @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL)
    List<Booking> bookings = new ArrayList<>();

}
