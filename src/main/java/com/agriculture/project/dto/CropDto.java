package com.agriculture.project.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CropDto {

    private Long id;
    private String cropName;          // e.g. Maize, Tomatoes
    private String variety;           // e.g. Sweet corn, Cherry tomato
    private LocalDate plantingDate;
    private LocalDate expectedHarvestDate;
    private LocalDate actualHarvestDate;
    private double yield;             // quantity harvested
    private String yieldUnit;         // e.g. kg, tons, bags
    private String growthStage;       // e.g. seedling, vegetative, flowering
    private String healthStatus;
}
