package com.event_booking.booking.service;

import com.event_booking.booking.entities.Event;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class StandardPricing implements Pricing {

    @Override
    public float calculatePrice(Event event) {
        return event.getPrice();
    }

}