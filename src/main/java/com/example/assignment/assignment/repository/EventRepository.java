package com.example.assignment.assignment.repository;


import com.example.assignment.assignment.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {}