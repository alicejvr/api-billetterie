
package com.event_booking.booking.dto;

public class BookingResponse {

    private long id;
    private long eventId;
    private int nbPlaces;
    private float price;

    public BookingResponse() {
    }

    public BookingResponse(long id, long eventId, int nbPlaces, float price) {
        this.id = id;
        this.eventId = eventId;
        this.nbPlaces = nbPlaces;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public long getEventId() {
        return eventId;
    }

    public int getNbPlaces() {
        return nbPlaces;
    }

    public float getPrice() {
        return price;
    }
}
