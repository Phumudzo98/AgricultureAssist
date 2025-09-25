package com.agriculture.project.mapper;

import com.agriculture.project.dto.CropDto;
import com.agriculture.project.model.Crop;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CropMapper {

    CropDto toCropDto(Crop crop);
    Crop toCrop(CropDto cropDto);
}
