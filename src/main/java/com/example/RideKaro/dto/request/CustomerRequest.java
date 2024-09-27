package com.example.RideKaro.dto.request;

import com.example.RideKaro.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerRequest {
    String name;
    int age;
    String email;
    Gender gender;
}
