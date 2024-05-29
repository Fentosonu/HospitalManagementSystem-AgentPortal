package com.Hospital.AgentPortal.Reository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Hospital.AgentPortal.Entity.LabTest;

@Repository
public interface LabTestRepository extends CrudRepository<LabTest, Long>{
	

}
