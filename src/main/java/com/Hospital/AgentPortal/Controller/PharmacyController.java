package com.Hospital.AgentPortal.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Hospital.AgentPortal.Entity.Medication;
import com.Hospital.AgentPortal.Service.PharmacyService;

@RestController
@RequestMapping("/api/medications")
public class PharmacyController {
    @Autowired
    private PharmacyService pharmacyService;

    @GetMapping
    public List<Medication> getAllMedications() {
        return pharmacyService.getAllMedications();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medication> getMedicationById(@PathVariable Long id) {
        Medication medication = pharmacyService.getMedicationById(id);
        if (medication != null) {
            return ResponseEntity.ok(medication);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Medication createMedication(@RequestBody Medication medication) {
        return pharmacyService.saveMedication(medication);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Medication> updateMedication(@PathVariable Long id, @RequestBody Medication medicationDetails) {
        Medication updatedMedication = pharmacyService.updateMedication(id, medicationDetails);
        return ResponseEntity.ok(updatedMedication);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedication(@PathVariable Long id) {
        pharmacyService.deleteMedication(id);
        return ResponseEntity.noContent().build();
    }
}