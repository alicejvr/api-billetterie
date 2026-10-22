package com.event_booking.booking.service;

import com.event_booking.booking.entities.Event;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EarlyBirdPricing implements  Pricing {

    private final StandardPricing standardPricing;
    private float taux;

    public EarlyBirdPricing(StandardPricing standardPricing, @Value("${taux-earlybird}") float taux) {
        this.standardPricing = standardPricing;
        this.taux = taux;
    }

    public float calculatePrice(Event event) {
        return standardPricing.calculatePrice(event) * (1 - taux /100);
    }


}