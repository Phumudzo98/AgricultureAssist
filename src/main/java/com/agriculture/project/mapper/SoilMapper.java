package com.agriculture.project.mapper;


import com.agriculture.project.dto.SoilDto;
import com.agriculture.project.model.Soil;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SoilMapper {

    Soil toEntity(SoilDto soilDto);
    SoilDto toDto(Soil soil);

    List<SoilDto> toDtos(List<Soil> soils);

}
