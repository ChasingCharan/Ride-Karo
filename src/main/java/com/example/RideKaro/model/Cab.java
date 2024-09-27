package com.example.RideKaro.model;

import com.example.RideKaro.Enum.CabType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Cab {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String cabNumber;
    @Enumerated(EnumType.STRING)
    CabType cabType;

    double farePerKm;

    boolean booked;

    @OneToOne
    @JoinColumn
    @JsonIgnore
    Driver driver;
}
