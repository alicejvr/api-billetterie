
package com.event_booking.booking.dto;

public record BookingRequest(
        long eventId,
        int nbPlaces
) {
}
