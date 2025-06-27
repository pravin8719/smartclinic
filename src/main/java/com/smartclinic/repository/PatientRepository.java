package com.smartclinic.repository;

import com.smartclinic.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    // ✅ Custom method to find patient by email
    Optional<Patient> findByEmail(String email);

    // ✅ Custom method to find patient by phone number
    Optional<Patient> findByContact(String contact);
}
