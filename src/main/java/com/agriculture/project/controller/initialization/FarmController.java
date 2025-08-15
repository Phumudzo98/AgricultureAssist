package com.agriculture.project.controller.initialization;


import com.agriculture.project.dto.FarmDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/farm")
public interface FarmController {

    @PostMapping("create-farm")
    FarmDto createFarm(FarmDto farmDto);

    @GetMapping("get-farms")
    List<FarmDto> getFarms();

    @GetMapping("get-farm/{id}")
    FarmDto getFarmById(@PathVariable int id);

    @DeleteMapping("delete-farm/{id}")
    boolean deleteFarm(@PathVariable int id);

    @GetMapping("search-farm/{name}")
    List<FarmDto> searchFarm(@PathVariable String name);
}
