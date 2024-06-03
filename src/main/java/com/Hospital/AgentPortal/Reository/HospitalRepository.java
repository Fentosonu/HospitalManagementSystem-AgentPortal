package com.Hospital.AgentPortal.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Hospital.AgentPortal.Entity.Hospital;

@Repository

public interface HospitalRepository extends CrudRepository<Hospital, Long>  {

}
