package com.cs.doctorservice.repository;

import com.cs.doctorservice.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}

