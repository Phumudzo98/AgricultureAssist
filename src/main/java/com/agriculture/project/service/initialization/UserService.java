package com.agriculture.project.service.initialization;

import com.agriculture.project.dto.UserDto;


public interface UserService {

    String deleteAccount();

    UserDto updateProfile(UserDto userDto);
}
