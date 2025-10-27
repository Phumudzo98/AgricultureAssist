package com.agriculture.project.controller.initialization;


import com.agriculture.project.dto.AddCropDto;
import com.agriculture.project.dto.CropDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/crop")
public interface CropController {

    @PostMapping("/add-crop/{landId}")
    public CropDto addCrop(@RequestBody CropDto cropDto, @PathVariable Long landId);

    @GetMapping("/crop-details/{id}")
    public CropDto cropDetails(@PathVariable Long id);

    @GetMapping("/crop-by-land/{landId}")
    public List<CropDto> cropByLand(@PathVariable Long landId);

    @DeleteMapping("/{cropId}")
    public Boolean deleteCrop(@PathVariable Long cropId);

    @PutMapping("/update-crop/{cropId}")
    public CropDto updateCrop(@PathVariable Long cropId, @RequestBody CropDto cropDto);




}
