package com.Hospital.AgentPortal.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Hospital.AgentPortal.Entity.Doctor;

@Repository

public interface DoctorRepository extends CrudRepository<Doctor, Long> {

}