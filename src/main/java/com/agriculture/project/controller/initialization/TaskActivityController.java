package com.agriculture.project.controller.initialization;


import com.agriculture.project.dto.TaskActivityDto;
import com.agriculture.project.model.TaskActivity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RequestMapping("/task-activity")
public interface TaskActivityController {

    @PostMapping("/create-task/{landId}")
    public TaskActivityDto create(@RequestBody TaskActivity taskActivity, @PathVariable("landId") Long landId);

    @GetMapping("/{id}")
    public TaskActivityDto getById(@PathVariable Long id);

    @GetMapping("/by-land/{landId}")
    public List<TaskActivityDto> getByLand(@PathVariable Long landId);

    @GetMapping("/daily/{landId}")
    public List<TaskActivityDto> getByDate(@RequestParam LocalDate date, @PathVariable Long landId);

    @PutMapping("/{id}")
    public TaskActivityDto update(@PathVariable Long id, @RequestBody TaskActivityDto taskActivity);

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Long id);
}
