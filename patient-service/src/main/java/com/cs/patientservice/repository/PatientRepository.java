package com.cs.patientservice.repository;

import com.cs.patientservice.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PatientRepository extends JpaRepository<Patient, Long> {
}

