package com.event_booking.booking.pricing;

import com.event_booking.booking.entities.Event;

public interface Pricing {
    float calculatePrice(Event event);
}
