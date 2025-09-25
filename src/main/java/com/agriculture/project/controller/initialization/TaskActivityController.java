package com.agriculture.project.controller.initialization;


import com.agriculture.project.model.TaskActivity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/task-activity")
public interface TaskActivityController {

    @PostMapping
    public TaskActivity create(@RequestBody TaskActivity taskActivity, Long id);

    @GetMapping("/{id}")
    public TaskActivity getById(@PathVariable Long id);

    @GetMapping("/by-land/{landId}")
    public List<TaskActivity> getByLand(@PathVariable Long landId);

    @GetMapping("/daily")
    public List<TaskActivity> getByDate(@RequestParam String date);

    @PutMapping("/{id}")
    public TaskActivity update(@PathVariable Long id, @RequestBody TaskActivity taskActivity);

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Long id);
}
