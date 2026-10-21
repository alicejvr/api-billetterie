package com.event_booking.booking.service;

import com.event_booking.booking.entities.Event;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PricingService {

    public EarlyBirdPricing earlyBirdPricing;
    public StandardPricing standardPricing;
    public LocalDate date = LocalDate.now();

    @Value("${seuil-jours}")
    private int seuilJours;

    public float selectPrice(Event event) {
        LocalDate date = LocalDate.now();

        // si la résa est faite + de 30 jours avant le début de l'événement
        if (event.getStartDate().isAfter(date.plusDays(seuilJours))) {
            return earlyBirdPricing.calculatePrice(); // tarif EarlyBird
        }
        return standardPricing.getPrice(); // sinon : tarif sandard
    }

}




