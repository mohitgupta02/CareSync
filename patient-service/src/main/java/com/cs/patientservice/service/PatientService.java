package com.cs.patientservice.service;

import com.cs.patientservice.dto.PatientDTO;
import com.cs.patientservice.entity.Patient;
import com.cs.patientservice.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService {

    @Autowired
    private PatientRepository repository;

    public List<PatientDTO> getAllPatients() {
        return repository.findAll().stream()
                .map(p -> PatientDTO.builder()
                        .id(p.getId())
                        .name(p.getName())
                        .age(p.getAge())
                        .email(p.getEmail())
                        .build())
                .collect(Collectors.toList());
    }

    public PatientDTO getPatientById(Long id) {
        return repository.findById(id)
                .map(p -> PatientDTO.builder()
                        .id(p.getId())
                        .name(p.getName())
                        .age(p.getAge())
                        .email(p.getEmail())
                        .build())
                .orElse(null);
    }

    public PatientDTO savePatient(PatientDTO dto) {
        Patient saved = repository.save(Patient.builder()
                .name(dto.getName())
                .age(dto.getAge())
                .email(dto.getEmail())
                .build());

        dto.setId(saved.getId());
        return dto;
    }

    public void deletePatient(Long id) {
        repository.deleteById(id);
    }
}

