package com.example.assignment.assignment.entities;

import lombok.*;
import jakarta.persistence.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Time;
import java.util.Date;

@Getter
@Setter
@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private Date date;
    private Time time;

    @ManyToOne
    private User user; // User who created the event

}
