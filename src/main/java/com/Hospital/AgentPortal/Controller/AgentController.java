package com.Hospital.AgentPortal.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Hospital.AgentPortal.Entity.Hospital;
import com.Hospital.AgentPortal.Entity.Referral;
import com.Hospital.AgentPortal.Service.AgentService;
import com.Hospital.AgentPortal.Service.HospitalService;

@RestController
@RequestMapping("/api/agents")
public class AgentController {

    @Autowired
    private AgentService agentService;

    @Autowired
    private HospitalService hospitalService;

    // Endpoint for agents to view all hospitals
    @GetMapping("/hospitals")
    public ResponseEntity<List<Hospital>> getAllHospitals() {
        List<Hospital> hospitals = hospitalService.getAllHospitals();
        return ResponseEntity.ok(hospitals);
    }

    // Endpoint for agents to refer a hospital
    @PostMapping("/refer")
    public ResponseEntity<String> referHospital(@RequestParam Long agentId, @RequestParam Long hospitalId) {
        boolean success = agentService.referHospital(agentId, hospitalId);
        if (success) {
            return ResponseEntity.ok("Hospital referred successfully");
        } else {
            return ResponseEntity.status(400).body("Failed to refer hospital");
        }
    }

    // Endpoint for agents to view their referral history
    @GetMapping("/{agentId}/referrals")
    public ResponseEntity<List<Referral>> getReferralHistory(@PathVariable Long agentId) {
        List<Referral> referrals = agentService.getReferralHistory(agentId);
        return ResponseEntity.ok(referrals);
    }
}
