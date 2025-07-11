package com.agriculture.project.controller.initialization;


import com.agriculture.project.dto.LoginDto;
import com.agriculture.project.dto.RegisterDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/auth")
public interface AuthApi {


    @PostMapping("/login")
    public String login(@RequestBody LoginDto loginDto);

    @PostMapping("/register")
    public String register(@RequestBody RegisterDto registerDto);
}
