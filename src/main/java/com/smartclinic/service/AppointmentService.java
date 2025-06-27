package com.smartclinic.service;

import com.smartclinic.model.Appointment;
import com.smartclinic.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service layer for managing appointments.
 */
@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    // ✅ Constructor-based Dependency Injection
    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    /**
     * Book a new appointment.
     * Validates that the appointment is not null.
     *
     * @param appointment Appointment to be booked
     * @return Saved appointment
     * @throws IllegalArgumentException if appointment is null
     */
    public Appointment bookAppointment(Appointment appointment) {
        if (appointment == null) {
            throw new IllegalArgumentException("Appointment must not be null");
        }
        return appointmentRepository.save(appointment);
    }

    /**
     * Get all appointments.
     *
     * @return List of all appointments
     */
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    /**
     * Get an appointment by ID.
     *
     * @param id Appointment ID
     * @return Optional containing the appointment if found, or empty if not
     */
    public Optional<Appointment> getAppointmentById(Long id) {
        return appointmentRepository.findById(id);
    }

    /**
     * Delete an appointment by ID.
     *
     * @param id Appointment ID
     */
    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }

    /**
     * Update an existing appointment.
     * Validates that the appointment and its ID are not null, and that it exists.
     *
     * @param appointment Updated appointment data
     * @return Updated appointment
     * @throws IllegalArgumentException if appointment is invalid or not found
     */
    public Appointment updateAppointment(Appointment appointment) {
        if (appointment == null || appointment.getId() == null) {
            throw new IllegalArgumentException("Appointment and ID must not be null");
        }
        if (appointmentRepository.existsById(appointment.getId())) {
            return appointmentRepository.save(appointment);
        } else {
            throw new IllegalArgumentException("Appointment with ID " + appointment.getId() + " does not exist");
        }
    }
}
