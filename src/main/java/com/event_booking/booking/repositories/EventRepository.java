package com.event_booking.booking.repositories;

import com.event_booking.booking.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

    public interface EventRepository extends JpaRepository<Event, Long> {
    }

