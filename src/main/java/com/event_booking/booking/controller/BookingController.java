package com.event_booking.booking.controller;

import com.event_booking.booking.entities.Booking;
import com.event_booking.booking.service.BookingService;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookingController {
    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/booking")
    public Booking book(@RequestBody Booking booking) {
        return bookingService.book(booking);
    }

    @DeleteMapping("/booking/{bookingId}")
    public void deleteBooking(@PathVariable String bookingId) {
        bookingService.deleteBooking(bookingId);
    }


}



