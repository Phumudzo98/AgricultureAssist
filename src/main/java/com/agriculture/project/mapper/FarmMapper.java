package com.agriculture.project.mapper;


import com.agriculture.project.dto.FarmDto;
import com.agriculture.project.model.Farm;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FarmMapper {

    FarmDto toDto(Farm farm);
    Farm fromDto(FarmDto farmDto);
    List<FarmDto> toDto(List<Farm> farms);
}
