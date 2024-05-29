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

import com.Hospital.AgentPortal.Entity.LabTest;
import com.Hospital.AgentPortal.Service.LabTestService;

@RestController
@RequestMapping("/api/lab-tests")
public class LabTestController {
    @Autowired
    private LabTestService labTestService;

    @GetMapping
    public List<LabTest> getAllLabTests() {
        return labTestService.getAllLabTests();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LabTest> getLabTestById(@PathVariable Long id) {
        LabTest labTest = labTestService.getLabTestById(id);
        if (labTest != null) {
            return ResponseEntity.ok(labTest);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public LabTest createLabTest(@RequestBody LabTest labTest) {
        return labTestService.createLabTest(labTest);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLabTest(@PathVariable Long id) {
        labTestService.deleteLabTest(id);
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<LabTest> updateLabTest(@PathVariable Long id, @RequestBody LabTest labTestDetails) {
        LabTest updatedLabTest = labTestService.updateLabTest(id, labTestDetails);
        return ResponseEntity.ok(updatedLabTest);
    }
}