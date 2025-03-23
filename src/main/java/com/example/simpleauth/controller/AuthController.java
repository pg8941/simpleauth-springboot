// src/main/java/com/example/simpleauth/controller/AuthController.java
package com.example.simpleauth.controller;

import com.example.simpleauth.model.User;
import com.example.simpleauth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Map<String, String> payload) {
        try {
            User user = userService.registerUser(payload.get("username"), payload.get("password"), payload.get("role"));
            if (user != null) {
                return ResponseEntity.ok("User registered: " + user.getUsername());
            } else {
                return ResponseEntity.badRequest().body("Registration failed.");
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Registration failed: " + e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> payload) {
        User user = userService.findUserByUsername(payload.get("username"));
        if (user != null) {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            if (passwordEncoder.matches(payload.get("password"), user.getPassword())) {
                return ResponseEntity.ok("Login successful");
            }
        }
        return ResponseEntity.badRequest().body("Invalid credentials");
    }
}