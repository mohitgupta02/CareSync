package com.cs.patientservice.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientDTO {
    private Long id;
    private String name;
    private int age;
    private String email;
}

