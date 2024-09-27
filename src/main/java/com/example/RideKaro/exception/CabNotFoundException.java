package com.example.RideKaro.exception;

public class CabNotFoundException extends RuntimeException {
    public CabNotFoundException(String message) {

      super(message);
    }
}
