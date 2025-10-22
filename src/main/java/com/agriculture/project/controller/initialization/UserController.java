package com.agriculture.project.controller.initialization;


import com.agriculture.project.dto.UserDto;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
public interface UserController {


    @DeleteMapping("delete-account")
    String deleteAccount();

    @PutMapping("update-profile")
    UserDto updateProfile(@RequestBody UserDto userDto);
}
