package com.Hospital.AgentPortal.Reository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Hospital.AgentPortal.Entity.Medication;

@Repository
public interface MedicationRepository extends CrudRepository<Medication, Long> {

}
