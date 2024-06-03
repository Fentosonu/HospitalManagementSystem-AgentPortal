package com.Hospital.AgentPortal.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Hospital.AgentPortal.Entity.Doctor;
import com.Hospital.AgentPortal.Exception.ResourceNotFoundException;
import com.Hospital.AgentPortal.Repository.DoctorRepository;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public List<Doctor> getAllDoctors() {
        return (List<Doctor>) doctorRepository.findAll();
    }

    public Doctor getDoctorById(Long doctorId) {
        return doctorRepository.findById(doctorId).orElseThrow(() -> new ResourceNotFoundException("Doctor not found for this id :: " + doctorId));
    }

    public Doctor updateDoctor(Long doctorId, Doctor doctorDetails) {
        Doctor doctor = getDoctorById(doctorId);
        doctor.setName(doctorDetails.getName());
        doctor.setSpecialization(doctorDetails.getSpecialization());
        doctor.setEmail(doctorDetails.getEmail());
        doctor.setPhone(doctorDetails.getPhone());
        return doctorRepository.save(doctor);
    }

    public void deleteDoctor(Long doctorId) {
        Doctor doctor = getDoctorById(doctorId);
        doctorRepository.delete(doctor);
    }
}
