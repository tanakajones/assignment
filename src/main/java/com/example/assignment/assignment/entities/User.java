package com.example.assignment.assignment.entities;


import lombok.*;
import jakarta.persistence.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password; // Store hashed password securely

    // Getters, setters, and methods for password hashing omitted for brevity

    @OneToMany(mappedBy = "user")
    private List<Event> events; // Events created by this user
}
