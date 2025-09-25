package com.agriculture.project.controller.implementation;

import com.agriculture.project.controller.initialization.TaskActivityController;
import com.agriculture.project.model.TaskActivity;
import com.agriculture.project.service.initialization.TaskActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class TaskActivityControllerImpl implements TaskActivityController {

    @Autowired
    public TaskActivityService taskActivityService;

    @Override
    public TaskActivity create(TaskActivity taskActivity, Long id) {
        return null;
    }

    @Override
    public TaskActivity getById(Long id) {
        return null;
    }

    @Override
    public List<TaskActivity> getByLand(Long landId) {
        return List.of();
    }

    @Override
    public List<TaskActivity> getByDate(String date) {
        return List.of();
    }

    @Override
    public TaskActivity update(Long id, TaskActivity taskActivity) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }
}
