package com.cs.appointmentservice.repository;

import com.cs.appointmentservice.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}

