package com.Hospital.AgentPortal.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Hospital.AgentPortal.Entity.Appointment;
import com.Hospital.AgentPortal.Exception.ResourceNotFoundException;
import com.Hospital.AgentPortal.Repository.AppointmentRepository;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public Appointment scheduleAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public List<Appointment> getAppointmentsByPatient(Long patientId) {
        return appointmentRepository.findByPatientId(patientId);
    }

    public void sendReminder(Appointment appointment) {
        // Implement email/SMS sending logic
        appointment.setReminderSent(true);
        appointmentRepository.save(appointment);
    }

    public Appointment findById(Long appointmentId) {
        Optional<Appointment> optionalAppointment = appointmentRepository.findById(appointmentId);
        if (optionalAppointment.isPresent()) {
            return optionalAppointment.get();
        } else {
            throw new ResourceNotFoundException("Appointment not found for this id :: " + appointmentId);
        }
    }
}