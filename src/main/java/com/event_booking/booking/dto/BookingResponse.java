
package com.event_booking.booking.dto;

public record BookingResponse(
        long id,
        long eventId,
        int nbPlaces,
        float price
) {
}
