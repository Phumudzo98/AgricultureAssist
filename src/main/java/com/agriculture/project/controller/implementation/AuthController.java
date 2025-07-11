package com.agriculture.project.controller.implementation;

import com.agriculture.project.controller.initialization.AuthApi;
import com.agriculture.project.dto.LoginDto;
import com.agriculture.project.dto.RegisterDto;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController implements AuthApi {
    @Override
    public String login(LoginDto loginDto) {
        return "";
    }

    @Override
    public String register(RegisterDto registerDto) {
        return "";
    }
}
