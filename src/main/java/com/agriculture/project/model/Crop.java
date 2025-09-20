package com.agriculture.project.model;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Crop {

    private String cropName;          // e.g. Maize, Tomatoes
    private String variety;           // e.g. Sweet corn, Cherry tomato
    private LocalDate plantingDate;
    private LocalDate expectedHarvestDate;
    private LocalDate actualHarvestDate;
    private double yield;             // quantity harvested
    private String yieldUnit;         // e.g. kg, tons, bags
    private String growthStage;       // e.g. seedling, vegetative, flowering
    private String healthStatus;      // e.g. healthy, diseased, pest-affected

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "land_id")
    private LandDetails landDetails;
}
