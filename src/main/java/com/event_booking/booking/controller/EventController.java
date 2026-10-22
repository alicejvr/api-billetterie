package com.event_booking.booking.controller;

import com.event_booking.booking.entities.Event;
import com.event_booking.booking.service.EventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping("/events")
    public Event createEvent(@RequestBody Event event) {
        return eventService.createEvent(event);
    }

    @GetMapping("/comingevents")
    public List<Event> getComingEvents() {
        return eventService.getComingEvents();
    }

    @GetMapping("/allevents")
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("/events/{eventId}")
    public Optional<Event> getEvent(@PathVariable int eventId) {
        return eventService.getEventById(eventId);
    }


}
