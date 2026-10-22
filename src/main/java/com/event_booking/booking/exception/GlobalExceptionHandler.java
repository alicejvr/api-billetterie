package com.event_booking.booking.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BookingException.class)
    public ResponseEntity<String> handleBookingException(
            BookingException exception) {

        return ResponseEntity
                .status(exception.getStatus())
                .body(exception.getMessage());
    }
}