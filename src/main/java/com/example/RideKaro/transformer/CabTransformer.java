package com.example.RideKaro.transformer;

import com.example.RideKaro.dto.request.CabRequest;
import com.example.RideKaro.dto.response.CabResponse;
import com.example.RideKaro.model.Cab;

public class CabTransformer {
    public static Cab cabRequestToCab(CabRequest cabRequest) {
        return Cab.builder()
                .cabType(cabRequest.getCabType())
                .cabNumber(cabRequest.getCabNumber())
                .farePerKm(cabRequest.getFarePerKm())
                .booked(false)
                .build();
    }

    public static CabResponse cabToCabResponse(Cab cab) {
        return CabResponse.builder()
                .booked(cab.isBooked())
                .cabNumber(cab.getCabNumber())
                .cabType(cab.getCabType())
                .farePerKm(cab.getFarePerKm())
                .build();
    }
}
