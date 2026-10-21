package com.event_booking.booking.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Booking {
    @Id
    public String id;
    @ManyToOne
    public Event event;
    public int nbPlaces;
    public float price;

    public Booking(String id, Event event, int nbPlaces, float price) {
        this.id = id;
        this.event = event;
        this.nbPlaces = nbPlaces;
        this.price = price;
    }

    public Booking() {

    }

    public String getId() {
        return id;
    }

    public Event getEvent() {
        return event;
    }

    public int getNbPlaces() {
        return nbPlaces;
    }

    public float getPrice() {
        return price;
    }

}
