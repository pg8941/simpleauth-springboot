package com.example.simpleauth.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin") // All endpoints in this controller are under /admin
public class AdminController {

    @GetMapping("/dashboard") // Endpoint: /admin/dashboard
    public ResponseEntity<String> adminDashboard() {
    	//logger.info("Admin Dashboard endpoint was hit!");
        return ResponseEntity.ok("Welcome to the Admin Dashboard!");
    }

    // You can add more admin-specific endpoints here...
    @GetMapping("/users")
    public ResponseEntity<String> manageUsers(){
        return ResponseEntity.ok("Admin can manage users here");
    }

    @GetMapping("/reports")
    public ResponseEntity<String> viewReports(){
        return ResponseEntity.ok("Admin can view reports here");
    }
}