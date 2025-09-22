package com.agriculture.project.dto;

import java.time.LocalDate;

public class AddCropDto {

    private String cropName;          // e.g. Maize, Tomatoes
    private String variety;           // e.g. Sweet corn, Cherry tomato
    private LocalDate plantingDate;
    private LocalDate expectedHarvestDate;
    private LocalDate actualHarvestDate;
    private Long land_details_id;
}
