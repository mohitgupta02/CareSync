package com.cs.doctorservice.controller;

import com.cs.doctorservice.dto.DoctorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.cs.doctorservice.service.DoctorService;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping
    public List<DoctorDTO> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    @GetMapping("/{id}")
    public DoctorDTO getDoctorById(@PathVariable Long id) {
        return doctorService.getDoctorById(id);
    }

    @PostMapping
    public DoctorDTO createDoctor(@RequestBody DoctorDTO dto) {
        return doctorService.saveDoctor(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctor(id);
    }
}

