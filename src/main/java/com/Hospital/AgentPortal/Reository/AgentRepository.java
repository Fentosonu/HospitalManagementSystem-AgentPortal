package com.Hospital.AgentPortal.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Hospital.AgentPortal.Entity.Agent;
import com.Hospital.AgentPortal.Entity.Referral;

@Repository

public interface AgentRepository extends CrudRepository<Agent, Long> {

    @Query("SELECT r.hospital FROM Referral r WHERE r.agent.id = :agentId")
    List<Referral> findReferralsByAgentId(Long agentId);
}
