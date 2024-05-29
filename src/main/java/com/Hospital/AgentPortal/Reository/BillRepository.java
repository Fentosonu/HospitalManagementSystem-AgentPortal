package com.Hospital.AgentPortal.Reository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Hospital.AgentPortal.Entity.Bill;

@Repository
public interface BillRepository extends CrudRepository<Bill, Long> {
    List<Bill> findByPatientId(Long patientId);
}
