package com.Hospital.AgentPortal.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Hospital.AgentPortal.Entity.Medication;
import com.Hospital.AgentPortal.Reository.MedicationRepository;

@Service
public class PharmacyService {
    @Autowired
    private MedicationRepository medicationRepository;

    public List<Medication> getAllMedications() {
        return (List<Medication>) medicationRepository.findAll();
    }

    public Medication getMedicationById(Long id) {
        return medicationRepository.findById(id).orElse(null);
    }

    public Medication saveMedication(Medication medication) {
        return medicationRepository.save(medication);
    }

    public Medication updateMedication(Long id, Medication medicationDetails) {
        Medication medication = medicationRepository.findById(id).orElseThrow(() -> new RuntimeException("Medication not found"));
        medication.setName(medicationDetails.getName());
        medication.setDescription(medicationDetails.getDescription());
        medication.setStock(medicationDetails.getStock());
        medication.setCost(medicationDetails.getCost());
        return medicationRepository.save(medication);
    }

    public void deleteMedication(Long id) {
        medicationRepository.deleteById(id);
    }
}
