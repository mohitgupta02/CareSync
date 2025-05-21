package com.cs.appointmentservice.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppointmentDTO {
    private Long id;
    private Long doctorId;
    private Long patientId;
    private LocalDate date;
    private DoctorDTO doctor;
    private PatientDTO patient;
}

