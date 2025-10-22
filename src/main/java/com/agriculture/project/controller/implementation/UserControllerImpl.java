package com.agriculture.project.controller.implementation;


import com.agriculture.project.controller.initialization.UserController;
import com.agriculture.project.dto.UserDto;
import com.agriculture.project.mapper.UserMapper;
import com.agriculture.project.repository.UserRepository;
import com.agriculture.project.service.initialization.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {

    private UserMapper userMapper;
    private final UserService userService;

    @Override
    public String deleteAccount() {
        return userService.deleteAccount();
    }

    @Override
    public UserDto updateProfile(UserDto userDto) {
        return userService.updateProfile(userDto);
    }
}
