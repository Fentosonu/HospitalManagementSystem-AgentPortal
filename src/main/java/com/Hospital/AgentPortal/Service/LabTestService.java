package com.Hospital.AgentPortal.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Hospital.AgentPortal.Entity.LabTest;
import com.Hospital.AgentPortal.Reository.LabTestRepository;

@Service
public class LabTestService {
    @Autowired
    private LabTestRepository labTestRepository;

    public List<LabTest> getAllLabTests() {
        return (List<LabTest>) labTestRepository.findAll();
    }

    public LabTest getLabTestById(Long id) {
        return labTestRepository.findById(id).orElse(null);
    }

    public LabTest createLabTest(LabTest labTest) {
        return labTestRepository.save(labTest);
    }
    public LabTest updateLabTest(Long id, LabTest labTestDetails) {
        LabTest labTest = labTestRepository.findById(id).orElseThrow(() -> new RuntimeException("LabTest not found"));
        labTest.setName(labTestDetails.getName());
        labTest.setDescription(labTestDetails.getDescription());
        labTest.setCost(labTestDetails.getCost());
        return labTestRepository.save(labTest);
    }

    public void deleteLabTest(Long id) {
        labTestRepository.deleteById(id);
    }
}
