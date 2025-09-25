package com.agriculture.project.dto;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class SoilDto {

    private long id;
    private String soilType;
    private double phLevel;
    private double moistureLevel;
    private double nitrogen;
    private double phosphorus;
    private double potassium;
    private LocalDate lastTestedDate;
}
