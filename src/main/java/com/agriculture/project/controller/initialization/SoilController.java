package com.agriculture.project.controller.initialization;


import com.agriculture.project.dto.SoilDto;
import com.agriculture.project.model.Soil;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/soil")
public interface SoilController {

    @PostMapping
    public SoilDto create(@RequestBody SoilDto soil, Long id);

    @GetMapping("/{id}")
    public SoilDto getById(@PathVariable Long id);

    @GetMapping("/by-land/{landId}")
    public List<SoilDto> getByLand(@PathVariable Long landId);

    @PutMapping("/{id}")
    public SoilDto update(@PathVariable Long id, @RequestBody SoilDto soil);

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Long id);
    
}