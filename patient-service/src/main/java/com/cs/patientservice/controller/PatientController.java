package com.cs.patientservice.controller;

import com.cs.patientservice.dto.PatientDTO;
import com.cs.patientservice.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping
    public List<PatientDTO> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/{id}")
    public PatientDTO getPatientById(@PathVariable Long id) {
        return patientService.getPatientById(id);
    }

    @PostMapping
    public PatientDTO createPatient(@RequestBody PatientDTO dto) {
        return patientService.savePatient(dto);
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
    }
}

