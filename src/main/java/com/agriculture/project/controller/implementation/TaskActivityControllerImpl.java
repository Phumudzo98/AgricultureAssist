package com.agriculture.project.controller.implementation;

import com.agriculture.project.controller.initialization.TaskActivityController;
import com.agriculture.project.dto.TaskActivityDto;
import com.agriculture.project.mapper.TaskActivityMapper;
import com.agriculture.project.model.TaskActivity;
import com.agriculture.project.service.initialization.TaskActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequiredArgsConstructor
public class TaskActivityControllerImpl implements TaskActivityController {

    @Autowired
    private TaskActivityService taskActivityService;
    private final TaskActivityMapper taskActivityMapper;


    @Override
    public TaskActivityDto create(TaskActivity taskActivity, Long landId) {
        return taskActivityMapper.toDto(taskActivityService.createTask(taskActivity, landId));
    }

    @Override
    public TaskActivityDto getById(Long id) {
        return taskActivityMapper.toDto(taskActivityService.getById(id));
    }

    @Override
    public List<TaskActivityDto> getByLand(Long landId) {
        return taskActivityMapper.toDtoList(taskActivityService.getByLand(landId));
    }

    @Override
    public List<TaskActivityDto> getByDate(LocalDate date, Long landId) {
        return taskActivityMapper.toDtoList(taskActivityService.getByDate(date,landId));
    }

    @Override
    public TaskActivityDto update(Long id, TaskActivityDto taskActivity) {


        return taskActivityMapper.toDto(taskActivityService.updateTask(id,taskActivity));
    }

    @Override
    public Boolean delete(Long id) {
        return taskActivityService.delete(id);
    }
}
