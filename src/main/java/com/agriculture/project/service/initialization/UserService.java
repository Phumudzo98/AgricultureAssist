package com.agriculture.project.service.initialization;

import com.agriculture.project.dto.UserDto;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserService {

    String deleteAccount();

    UserDto updateProfile(UserDto userDto);
}
