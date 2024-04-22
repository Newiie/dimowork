package com.example.preFinal.controller;


import com.example.preFinal.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.preFinal.repository.UserRepository;

public class UserController {
    // Autowire the UserRepository
    @Autowired
    private UserRepository userRepository;

    // Modify the login method
    @PostMapping("/login")
    public ResponseEntity<?> login(
            @RequestParam("firstname") String firstName,
            @RequestParam("lastname") String lastName) {

        // Query the user repository to find the user by firstname and lastname
        User user = userRepository.findByFirstnameAndLastname(firstName, lastName);

        // Check if the user exists
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(500).body("Invalid credentials");
        }
    }

    // Create User method
    @PostMapping("/users")
    public ResponseEntity<?> createUser(
            @RequestParam("firstname") String firstName,
            @RequestParam("lastname") String lastName) {

        // Create a new User object
        User newUser = new User();
        newUser.setFirstname(firstName);
        newUser.setLastname(lastName);

        userRepository.save(newUser);

        return ResponseEntity.status(200).body(newUser);
    }
}
