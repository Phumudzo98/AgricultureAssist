package com.agriculture.project.controller.initialization;


import com.agriculture.project.dto.TaskActivityDto;
import com.agriculture.project.model.TaskActivity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/task-activity")
public interface TaskActivityController {

    @PostMapping
    public TaskActivityDto create(@RequestBody TaskActivity taskActivity, Long id);

    @GetMapping("/{id}")
    public TaskActivityDto getById(@PathVariable Long id);

    @GetMapping("/by-land/{landId}")
    public List<TaskActivityDto> getByLand(@PathVariable Long landId);

    @GetMapping("/daily")
    public List<TaskActivityDto> getByDate(@RequestParam String date);

    @PutMapping("/{id}")
    public TaskActivityDto update(@PathVariable Long id, @RequestBody TaskActivityDto taskActivity);

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Long id);
}
