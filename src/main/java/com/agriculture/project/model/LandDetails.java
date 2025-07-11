package com.agriculture.project.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LandDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String sectionName;
    private String soilType;
    private LocalDate lastPlantedDate;
    private LocalDate lastHarvestDate;
    private String irrigationType;
    private boolean underCultivation;
    private String latitude;
    private String longitude;
    private String notes;
    private double size;
    private String metrics;
}
