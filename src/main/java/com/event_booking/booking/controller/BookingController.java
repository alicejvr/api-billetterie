package com.event_booking.booking.controller;

import com.event_booking.booking.dto.BookingRequest;
import com.event_booking.booking.dto.BookingResponse;
import com.event_booking.booking.entities.Booking;
import com.event_booking.booking.service.BookingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingController {
    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/booking")
    public BookingResponse book(@RequestBody BookingRequest request) {

        Booking booking = bookingService.book(request);

        return new BookingResponse(
                booking.getId(),
                booking.getEvent().getId(),
                booking.getNbPlaces(),
                booking.getPrice()
        );
    }

    @GetMapping("/booking")
    public List<Booking> bookings() {
        return bookingService.getAllBookings();
    }

    @DeleteMapping("/booking/{bookingId}")
    public void cancelBooking(@PathVariable long bookingId) {
        bookingService.cancelBooking(bookingId);
    }


}



