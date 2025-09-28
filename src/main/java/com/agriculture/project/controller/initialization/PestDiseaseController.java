package com.agriculture.project.controller.initialization;


import com.agriculture.project.dto.PestDiseaseDto;
import com.agriculture.project.model.PestDisease;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/pest-disease")
public interface PestDiseaseController {

    @PostMapping
    public PestDiseaseDto create(@RequestBody PestDisease pestDisease, Long id);

    @GetMapping("/{id}")
    public PestDiseaseDto getById(@PathVariable Long id);

    @GetMapping("/by-crop/{cropId}")
    public List<PestDiseaseDto> getByCrop(@PathVariable Long cropId);

    @PutMapping("/{id}")
    public PestDiseaseDto update(@PathVariable Long id, @RequestBody PestDisease pestDisease);

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Long id);


}
