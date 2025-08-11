package com.agriculture.project.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FarmDto {

    private long id;
    private String farm_name;
    private String farm_type;
    private String farm_location;
    private String farm_description;
    private double size;
    private String metrics;
    private Byte image;

    private List<LandDetailsDto> landDetails;
}
