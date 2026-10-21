package com.event_booking.booking.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String name;
    public LocalDate startDate;
    public float price;

    @Value("${places-max}")
    private int capacity;

    public Event(String name, int id, LocalDate startDate, int capacity, float price) {
        this.name = name;
        this.id = id;
        this.startDate = startDate;
        this.capacity = capacity;
        this.price = price;
        }

    public Event() {

    }

    public String getName() {
        return name;
    }

    public int getId() {
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


