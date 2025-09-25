package com.agriculture.project.controller.initialization;


import com.agriculture.project.dto.AddCropDto;
import com.agriculture.project.dto.CropDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/crop")
public interface CropController {

    @PostMapping("/add-crop")
    public String addCrop(@RequestBody AddCropDto cropDto);

    @GetMapping("/crop-details/{id}")
    public CropDto cropDetails(@PathVariable int id);

    @GetMapping("/crop-by-land/{landId}")
    public List<CropDto> cropByLand(@PathVariable int landId);




}
