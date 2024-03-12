package com.example.assignment.assignment.service;

import com.example.assignment.assignment.entities.User;
import com.example.assignment.assignment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(User user) {
        // Check if a user with the same username already exists
        if(userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new RuntimeException("User with username " + user.getUsername() + " already exists.");
        }

        // Encode the user's password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Save the user to the database
        return userRepository.save(user);
    }

    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User updateUser(Long id, User userDetails) {
        User user = getUser(id);
        user.setUsername(userDetails.getUsername());
        user.setPassword(passwordEncoder.encode(userDetails.getPassword()));
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        User user = getUser(id);
        userRepository.delete(user);
    }
    public User loginUser(User user) {
        User existingUser = userRepository.findByUsername(user.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if(!passwordEncoder.matches(user.getPassword(), existingUser.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return existingUser;
    }

}
