package com.springSecurityUpdated.springSecurityUpdated.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springSecurityUpdated.springSecurityUpdated.model.User;
import com.springSecurityUpdated.springSecurityUpdated.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        // Add logic to create a user in the database
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    // Add other user-related methods as needed

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    public boolean isUsernameTaken(String username) {
        return userRepository.findByUsername(username).isPresent();

    }

    public boolean isEmailTaken(String email) {
        return userRepository.findByEmail(email).isPresent();

    }
}
