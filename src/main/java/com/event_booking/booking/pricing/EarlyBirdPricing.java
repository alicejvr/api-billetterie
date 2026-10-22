package com.event_booking.booking.pricing;

import com.event_booking.booking.entities.Event;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EarlyBirdPricing implements  Pricing {

    private final Pricing standardPricing;
    private float taux;

    public EarlyBirdPricing(@Qualifier("standardPricing") Pricing standardPricing, @Value("${taux-earlybird}") float taux) {
        this.standardPricing = standardPricing;
        this.taux = taux;
    }

    public float calculatePrice(Event event) {
        return standardPricing.calculatePrice(event) * (1 - taux /100);
    }


}