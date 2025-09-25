package com.agriculture.project.mapper;


import com.agriculture.project.dto.TaskActivityDto;
import com.agriculture.project.model.TaskActivity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskActivityMapper {

    TaskActivity toEntity(TaskActivityDto taskActivityDto);
    TaskActivityDto toDto(TaskActivity taskActivity);

    List<TaskActivityDto> toDtoList(List<TaskActivity> taskActivityList);
}
