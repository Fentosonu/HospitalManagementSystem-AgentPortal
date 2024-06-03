package com.Hospital.AgentPortal.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Hospital.AgentPortal.Entity.Agent;
import com.Hospital.AgentPortal.Entity.Hospital;
import com.Hospital.AgentPortal.Entity.Referral;
import com.Hospital.AgentPortal.Repository.AgentRepository;
import com.Hospital.AgentPortal.Repository.HospitalRepository;
import com.Hospital.AgentPortal.Repository.ReferralRepository;

@Service
public class AgentService {

    @Autowired
    private AgentRepository agentRepository;

    @Autowired
    private HospitalRepository hospitalRepository;

    @Autowired
    private ReferralRepository referralRepository;

    // Refer a hospital
    public boolean referHospital(Long agentId, Long hospitalId) {
        try {
            Agent agent = agentRepository.findById(agentId).orElseThrow(() -> new RuntimeException("Agent not found"));
            Hospital hospital = hospitalRepository.findById(hospitalId).orElseThrow(() -> new RuntimeException("Hospital not found"));
            Referral referral = new Referral(agent, hospital);
            referralRepository.save(referral);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Get referral history for an agent
    public List<Referral> getReferralHistory(Long agentId) {
        return agentRepository.findReferralsByAgentId(agentId);
    }
}
