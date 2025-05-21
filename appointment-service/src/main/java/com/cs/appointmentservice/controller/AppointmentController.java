package com.cs.appointmentservice.controller;

import com.cs.appointmentservice.dto.AppointmentDTO;
import com.cs.appointmentservice.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping
    public List<AppointmentDTO> getAll() {
        return appointmentService.getAllAppointments();
    }

    @GetMapping("/{id}")
    public AppointmentDTO getById(@PathVariable Long id) {
        return appointmentService.getAppointment(id);
    }

    @PostMapping
    public AppointmentDTO create(@RequestBody AppointmentDTO dto) {
        return appointmentService.create(dto);
    }
}

