package com.event_booking.booking.entities;

import jakarta.persistence.*;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    @ManyToOne
    public Event event;
    public int nbPlaces;
    public float price;

    public Booking(Event event, int nbPlaces, float price) {
        this.event = event;
        this.nbPlaces = nbPlaces;
        this.price = price;
    }

    public Booking() {
    }

    public long getId() {
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
