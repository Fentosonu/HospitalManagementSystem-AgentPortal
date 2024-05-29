package com.Hospital.AgentPortal.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Hospital.AgentPortal.Entity.Patient;
import com.Hospital.AgentPortal.Reository.PatientRepository;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> getAllPatients() {
        return (List<Patient>) patientRepository.findAll();
    }

    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }
    
    public Patient updatePatient(Long id, Patient patientDetails) {
    	Patient patient = patientRepository.findById(id).orElseThrow(() -> new RuntimeException("Patient not found"));
    	patient.setName(patientDetails.getName());
    	patient.setEmail(patientDetails.getEmail());
    	patient.setPlace(patientDetails.getPlace());
    	patient.setPhone(patientDetails.getPhone());
        return patientRepository.save(patient);
    }
    public void deletePatient(Long id) {
    	patientRepository.deleteById(id);
    }

}