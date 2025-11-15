package com.agriculture.project.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LandDetailsDto {

    private Long id;
    private String sectionName;
    private String soilType;
    @JsonFormat(pattern = "yyyy-MM-dd")  // optional if frontend sends yyyy-MM-dd
    private LocalDate lastPlantedDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate lastHarvestDate;
    private String irrigationType;
    private boolean underCultivation;
    private String latitude;
    private String longitude;
    private String notes;
    private double size;
    private String metrics;
}
