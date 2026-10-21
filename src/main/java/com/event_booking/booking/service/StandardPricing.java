package com.event_booking.booking.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class StandardPricing implements Pricing {

    private float price = 50;

    @Override
    public float calculatePrice() {
        return price;
    }

    public float getPrice() {
        return price;
    }
}