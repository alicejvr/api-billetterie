package com.event_booking.booking;

import com.event_booking.booking.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

    public interface EventRepository extends JpaRepository<Event, Integer> {
    }

