package com.agriculture.project.mapper;


import com.agriculture.project.dto.FarmDto;
import com.agriculture.project.model.Farm;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FarmMapper {

    FarmDto toDto(Farm farm);
    Farm fromDto(FarmDto farmDto);
}
