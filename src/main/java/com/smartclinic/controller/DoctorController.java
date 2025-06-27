package com.smartclinic.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    // Example GET endpoint
    @GetMapping("/{id}")
    public ResponseEntity<String> getDoctorById(@PathVariable Long id) {
        // Dummy response for demo
        return ResponseEntity.ok("Doctor with ID " + id);
    }

    // ✅ New endpoint to check doctor availability
    @GetMapping("/availability/{user}/{doctorId}/{date}/{token}")
    public ResponseEntity<String> checkAvailability(
            @PathVariable String user,
            @PathVariable Long doctorId,
            @PathVariable String date,
            @PathVariable String token) {

        // Simple token validation (replace with real auth logic later)
        if (!isValidToken(token)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid token");
        }

        // Dummy logic to simulate availability
        boolean isAvailable = checkDoctorAvailability(doctorId, date);

        if (isAvailable) {
            return ResponseEntity.ok("Doctor is available on " + date);
        } else {
            return ResponseEntity.ok("Doctor is not available on " + date);
        }
    }

    // 🔐 Dummy method to simulate token validation
    private boolean isValidToken(String token) {
        return token != null && token.equals("valid-token");
    }

    // 🩺 Dummy method to simulate checking doctor availability
    private boolean checkDoctorAvailability(Long doctorId, String date) {
        // Replace this logic with actual DB check if needed
        return true; // assume always available
    }
}
