package com.example.assignment.assignment.service;

import com.example.assignment.assignment.entities.Event;
import com.example.assignment.assignment.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;


    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }

    public Event getEvent(Long id) {
        return eventRepository.findById(id).orElseThrow(() -> new RuntimeException("Event not found"));
    }

    public Event updateEvent(Long id, Event eventDetails) {
        Event event = getEvent(id);
        event.setTitle(eventDetails.getTitle());
        event.setDescription(eventDetails.getDescription());
        event.setDate(eventDetails.getDate());
        event.setTime(eventDetails.getTime());
        return eventRepository.save(event);
    }

    public void deleteEvent(Long id) {
        Event event = getEvent(id);
        eventRepository.delete(event);
    }

}
