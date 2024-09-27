package com.example.RideKaro.dto.response;

import com.example.RideKaro.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CustomerResponse {
    String name;
    int age;
    String email;
    Gender gender;
}
