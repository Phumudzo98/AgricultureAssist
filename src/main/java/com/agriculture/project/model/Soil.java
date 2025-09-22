package com.agriculture.project.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Soil {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private String soilType;         // e.g. Sandy, Clay, Loam
    private double phLevel;          // e.g. 6.5
    private double moistureLevel;    // %
    private double nitrogen;         // N content (mg/kg or ppm)
    private double phosphorus;       // P content
    private double potassium;        // K content
    private LocalDate lastTestedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "land_id")
    private LandDetails landDetails;
}
