package com.agriculture.project.mapper;

import com.agriculture.project.dto.PestDiseaseDto;
import com.agriculture.project.model.PestDisease;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PestDiseaseMapper {

    PestDisease toEntity(PestDiseaseDto pestDiseaseDto);
    PestDiseaseDto toDto(PestDisease pestDisease);
}
