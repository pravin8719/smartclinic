package com.smartclinic.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

    // ✅ Example GET endpoint
    @GetMapping
    public String getAllPrescriptions() {
        return "List of prescriptions";
    }

    // ✅ Example POST endpoint
    @PostMapping
    public String createPrescription() {
        return "Prescription created";
    }
}
