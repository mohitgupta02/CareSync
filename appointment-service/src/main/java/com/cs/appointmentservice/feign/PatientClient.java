package com.cs.appointmentservice.feign;

import com.cs.appointmentservice.dto.PatientDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "patient-service", url="${patient-service.url}")
public interface PatientClient {
    @GetMapping("/api/patients/{id}")
    PatientDTO getPatientById(@PathVariable("id") Long id);
}

