package com.event_booking.booking.service;

import com.event_booking.booking.entities.Event;

public interface Pricing {
    float calculatePrice(Event event);
}
