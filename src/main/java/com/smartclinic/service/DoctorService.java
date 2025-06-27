package com.smartclinic.service;

import com.smartclinic.model.Doctor;
import com.smartclinic.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    // ✅ Basic CRUD
    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Optional<Doctor> getDoctorById(Long id) {
        return doctorRepository.findById(id);
    }

    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }

    // ✅ Doctor login validation
  //  public boolean validateDoctorLogin(String email, String password) {
    //    Optional<Doctor> doctor = doctorRepository.findByEmailAndPassword(email, password);
    //    return doctor.isPresent();
   // }

    // ✅ Get available time slots for a doctor on a specific date
    public List<String> getAvailableTimeSlots(Long doctorId, LocalDate date) {
        // Dummy data - in real implementation, check booked appointments from DB
        return Arrays.asList("09:00 AM", "10:00 AM", "02:00 PM", "03:30 PM");
    }
}
