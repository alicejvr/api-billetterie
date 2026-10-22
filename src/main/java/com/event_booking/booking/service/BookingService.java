package com.event_booking.booking.service;

import com.event_booking.booking.dto.BookingRequest;
import com.event_booking.booking.entities.Booking;
import com.event_booking.booking.entities.Event;
import com.event_booking.booking.exception.BookingException;
import com.event_booking.booking.pricing.PricingService;
import com.event_booking.booking.repositories.BookingRepository;
import com.event_booking.booking.repositories.EventRepository;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class BookingService {

    private final PricingService pricingService;
    private final BookingRepository bookingRepository;
    private final EventRepository eventRepository;

    public BookingService(PricingService pricingService,BookingRepository bookingRepository, EventRepository eventRepository) {
        this.pricingService = pricingService;
        this.bookingRepository = bookingRepository;
        this.eventRepository = eventRepository;
    }

    // méthode qui permet d'effectuer la résa

    public Booking book(BookingRequest request) {

        long eventId = request.eventId();

        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new BookingException(
                        HttpStatus.NOT_FOUND,
                        "Événement introuvable"
                ));

        int nbPlaces = request.nbPlaces();

        if (nbPlaces < 1 || nbPlaces > 6) {
            throw new BookingException(
                    HttpStatus.BAD_REQUEST,
                    "Maximum 6 places"
            );
        }

        int placesReservees = 0;
        List<Booking> bookings = bookingRepository.findAll();

        for (Booking currentBooking : bookings) {
            if (currentBooking.getEvent().getId() == eventId) {
                placesReservees += currentBooking.getNbPlaces();
            }
        }

        int placesDisponibles = event.getCapacity() - placesReservees;

        if (nbPlaces > placesDisponibles) {
            throw new BookingException(
                    HttpStatus.CONFLICT,
                    "Plus assez de places disponibles pour cet événement"
            );
        }

        float price = pricingService.selectPrice(event) * nbPlaces;

        Booking newBooking = new Booking(event, nbPlaces, price);

        return bookingRepository.save(newBooking);
    }


    public void cancelBooking(long bookingId) {
        bookingRepository.deleteById(bookingId);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
}