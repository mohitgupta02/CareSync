package com.cs.appointmentservice.service;

import com.cs.appointmentservice.dto.AppointmentDTO;
import com.cs.appointmentservice.dto.DoctorDTO;
import com.cs.appointmentservice.dto.PatientDTO;
import com.cs.appointmentservice.entity.Appointment;
import com.cs.appointmentservice.feign.DoctorClient;
import com.cs.appointmentservice.feign.PatientClient;
import com.cs.appointmentservice.repository.AppointmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository repository;

    @Autowired
    private DoctorClient doctorClient;

    @Autowired
    private PatientClient patientClient;

    public List<AppointmentDTO> getAllAppointments() {
        return repository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public AppointmentDTO getAppointment(Long id) {
        return repository.findById(id)
                .map(this::mapToDTO)
                .orElse(null);
    }

    public AppointmentDTO create(AppointmentDTO dto) {
        Appointment saved = repository.save(Appointment.builder()
                .doctorId(dto.getDoctorId())
                .patientId(dto.getPatientId())
                .date(dto.getDate())
                .build());

        return mapToDTO(saved);
    }

    private AppointmentDTO mapToDTO(Appointment appt) {
        DoctorDTO doctor = null;
        PatientDTO patient = null;

        try {
            doctor = doctorClient.getDoctorById(appt.getDoctorId());
        } catch (Exception e) {
            log.error("Failed to fetch doctor with ID {}", appt.getDoctorId(), e);
        }

        try {
            patient = patientClient.getPatientById(appt.getPatientId());
        } catch (Exception e) {
            log.error("Failed to fetch patient with ID {}", appt.getPatientId(), e);
        }

        return AppointmentDTO.builder()
                .id(appt.getId())
                .doctorId(appt.getDoctorId())
                .patientId(appt.getPatientId())
                .date(appt.getDate())
                .doctor(doctor)
                .patient(patient)
                .build();
    }
}
