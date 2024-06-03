package com.Hospital.AgentPortal.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Hospital.AgentPortal.Entity.Hospital;
import com.Hospital.AgentPortal.Repository.HospitalRepository;

@Service

public class HospitalService {

    @Autowired
    private HospitalRepository hospitalRepository;

    // Get all hospitals
    public List<Hospital> getAllHospitals() {
        return (List<Hospital>) hospitalRepository.findAll();
    }
}
