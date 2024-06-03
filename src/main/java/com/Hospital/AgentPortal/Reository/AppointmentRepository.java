package com.Hospital.AgentPortal.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Hospital.AgentPortal.Entity.Appointment;

@Repository

public interface AppointmentRepository extends CrudRepository<Appointment, Long> {

	List<Appointment> findByPatientId(Long patientId);
	

}