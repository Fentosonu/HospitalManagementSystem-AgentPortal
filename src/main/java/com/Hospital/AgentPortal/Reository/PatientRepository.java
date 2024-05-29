package com.Hospital.AgentPortal.Reository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Hospital.AgentPortal.Entity.Patient;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Long> {

}
