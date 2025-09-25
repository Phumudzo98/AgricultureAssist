package com.agriculture.project.service.initialization;


import com.agriculture.project.model.TaskActivity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public interface TaskActivityService {

    public TaskActivity createTask(TaskActivity taskActivity, Long landId);

    public List<TaskActivity> getByLand(Long landId);

    public List<TaskActivity> getByDate(LocalDate date);

    public Optional<TaskActivity> getById(Long id);

    public TaskActivity updateTask(Long id, TaskActivity updated);

    public Boolean delete(Long id);
}
