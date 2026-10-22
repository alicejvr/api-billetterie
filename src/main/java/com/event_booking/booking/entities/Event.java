package com.event_booking.booking.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    public String name;
    public LocalDate startDate;
    public float price;
    private int capacity;

    public Event(String name, LocalDate startDate, int capacity, float price) {
        this.name = name;
        this.startDate = startDate;
        this.capacity = capacity;
        this.price = price;
        }

    public Event() {
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public int getCapacity() {
        return capacity;
    }

    public float getPrice() {
        return price;
    }
}


