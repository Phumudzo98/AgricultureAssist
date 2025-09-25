package com.agriculture.project.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PestDiseaseDto {

    private Long id;
    private String type;              // "Pest" or "Disease"
    private String name;              // e.g. Fall Armyworm, Late Blight
    private String severity;          // e.g. Low, Medium, High
    private LocalDate detectionDate;
    private String actionTaken;       // e.g. Sprayed pesticide, Pruned
    private String notes;
}
