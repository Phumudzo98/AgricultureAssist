package com.agriculture.project.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FarmOverviewDto {

    private String farmName;
    private String farmType;
    private String location;
    private String totalSize;
    private String underCultivation;
    private String notCultivated;
    private String numberOfSections;
    private String dominantSoilType;
    private String mainIrrigation;
}
