package com.smartclinic.repository;

import com.smartclinic.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository interface for Patient entity.
 * Provides CRUD operations and custom query methods
 * using Spring Data JPA.
 */
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    /**
     * Finds a patient by their email address.
     * @param email the email to search for
     * @return an Optional containing the matching patient, if found
     */
    Optional<Patient> findByEmail(String email);

    /**
     * Finds a patient by their contact number.
     * @param contact the contact number to search for
     * @return an Optional containing the matching patient, if found
     */
    Optional<Patient> findByContact(String contact);
}
