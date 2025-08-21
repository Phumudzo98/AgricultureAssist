package com.agriculture.project.controller.initialization;


import com.agriculture.project.dto.ChatResponse;
import com.agriculture.project.dto.FarmDto;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequestMapping("/farm")
public interface FarmController {

    @PostMapping("create-farm")
    FarmDto createFarm(@RequestBody FarmDto farmDto);

    @GetMapping("get-farms")
    List<FarmDto> getFarms();

    @PostMapping("/chat-with-ai")
    String chatWithAi(
            @RequestParam("message") String message,
            @RequestPart(value = "file", required = false) MultipartFile file
    );

    @GetMapping("get-farm/{id}")
    FarmDto getFarmById(@PathVariable Long id);

    @DeleteMapping("delete-farm/{id}")
    boolean deleteFarm(@PathVariable Long id);

    @GetMapping("search-farm/{name}")
    List<FarmDto> searchFarm(@PathVariable String name);

    @PutMapping("update-farm")
    FarmDto updateFarm(FarmDto farmDto);
}
