package com.event_booking.booking.service;

import com.event_booking.booking.repositories.EventRepository;
import com.event_booking.booking.entities.Event;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public List<Event> getComingEvents() {
        return eventRepository.findAll()
                .stream()
                .filter(event -> !event.startDate.isBefore(LocalDate.now()))
                .sorted(Comparator.comparing(event -> event.startDate))
                .toList();
    }

    public Optional<Event> getEventById(long id) {
        return eventRepository.findById(id);
    }

    public void deleteEvent(long id) {
        eventRepository.deleteById(id);
    }

}