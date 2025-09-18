package com.agriculture.project.mapper;


import com.agriculture.project.dto.FarmDto;
import com.agriculture.project.model.Farm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
@Mapper(componentModel = "spring")
public interface FarmMapper {

    FarmDto toDto(Farm farm);

    @Mapping(target = "id", ignore = true) // ignore ID when creating new Farm
    Farm fromDto(FarmDto farmDto);

    // ✅ MapStruct can automatically map lists
    List<FarmDto> toDtoList(List<Farm> farms);
}

