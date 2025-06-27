package com.smartclinic.service;

import com.smartclinic.model.Appointment;
import com.smartclinic.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    // ✅ Constructor-based Dependency Injection
    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    // ✅ Book new appointment with basic validation
    public Appointment bookAppointment(Appointment appointment) {
        if (appointment == null) {
            throw new IllegalArgumentException("Appointment must not be null");
        }
        return appointmentRepository.save(appointment);
    }

    // ✅ Get all appointments
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    // ✅ Get appointment by ID
    public Appointment getAppointmentById(Long id) {
        return appointmentRepository.findById(id).orElse(null);
    }

    // ✅ Delete appointment by ID
    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }

    // ✅ Update existing appointment
    public Appointment updateAppointment(Appointment appointment) {
        if (appointment == null || appointment.getId() == null) {
            throw new IllegalArgumentException("Appointment or ID must not be null");
        }
        if (appointmentRepository.existsById(appointment.getId())) {
            return appointmentRepository.save(appointment);
        } else {
            throw new IllegalArgumentException("Appointment with given ID does not exist");
        }
    }
}
