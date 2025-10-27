package com.agriculture.project.mapper;

import com.agriculture.project.dto.CropDto;
import com.agriculture.project.model.Crop;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CropMapper {

    CropDto toCropDto(Crop crop);
    Crop toCrop(CropDto cropDto);

    List<CropDto> toCropDtos(List<Crop> crops);
}
