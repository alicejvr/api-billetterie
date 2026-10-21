package com.event_booking.booking.service;

import com.event_booking.booking.entities.Booking;
import com.event_booking.booking.entities.Event;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingService {

    private final PricingService pricingService;
    private final List<Booking> bookings = new ArrayList<>();

    public BookingService(PricingService pricingService) {
        this.pricingService = pricingService;
    }

    public Booking book(Booking booking) {
        Event event = booking.getEvent();
        int nbPlaces = booking.getNbPlaces();
        int placesReservees = 0;

        for (Booking currentBooking : bookings) {
            if (currentBooking.getEvent().getId() == event.getId()) {
                placesReservees += currentBooking.getNbPlaces();
            }
        }

        if (nbPlaces < 1 || nbPlaces >= 6) {
            throw new IllegalArgumentException(
                    "Maximum 6 places"
            );
        }

        int placesDisponibles = event.getCapacity() - placesReservees;

        if (nbPlaces > placesDisponibles) {
            throw new IllegalArgumentException(
                    "Plus assez de place pr cet event"
            );
        }

        float price = pricingService.selectPrice(event);

        Booking newBooking = new Booking(
                booking.getId(),
                event,
                nbPlaces,
                price
        );

        bookings.add(newBooking);

        return newBooking;
    }

    public void deleteBooking(String bookingId) {
        bookings.removeIf(booking -> booking.getId().equals(bookingId));
    }
}