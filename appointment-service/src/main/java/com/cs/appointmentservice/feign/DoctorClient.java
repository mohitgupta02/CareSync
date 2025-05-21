package com.cs.appointmentservice.feign;

import com.cs.appointmentservice.dto.DoctorDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "doctor-service",
        url="${doctor-service.url}")
public interface DoctorClient {
    @GetMapping("/api/doctors/{id}")
    DoctorDTO getDoctorById(@PathVariable("id") Long id);
}

