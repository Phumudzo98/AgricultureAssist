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
    private String numberOfSections;

}
