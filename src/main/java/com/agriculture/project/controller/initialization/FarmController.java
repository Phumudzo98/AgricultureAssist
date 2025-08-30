package com.agriculture.project.controller.initialization;



import com.agriculture.project.dto.FarmDto;
import com.agriculture.project.dto.FarmOverviewDto;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequestMapping("/farm")
public interface FarmController {

    @PostMapping("/create-farm")
    FarmDto createFarm(@RequestBody FarmDto farmDto);

    @GetMapping("/farm-overview/{farmId}")
    FarmOverviewDto farmOverview(@PathVariable("farmId") Long farmId);

    @GetMapping("/get-farms")
    List<FarmDto> getFarms();

    @PostMapping("/analyze")
    public String analyzeImage(
            @RequestParam("prompt") String prompt,
            @RequestParam("file") MultipartFile file
    ) throws Exception;

    @PostMapping("/chat-with-ai")
    String chatWithAi(
            @RequestParam("message") String message,
            @RequestPart(value = "file", required = false) MultipartFile file
    );

    @GetMapping("/get-farm/{id}")
    FarmDto getFarmById(@PathVariable Long id);

    @DeleteMapping("/delete-farm/{id}")
    boolean deleteFarm(@PathVariable Long id);

    @GetMapping("/search-farm/{name}")
    List<FarmDto> searchFarm(@PathVariable String name);

    @PutMapping("/update-farm")
    FarmDto updateFarm(FarmDto farmDto);
}
