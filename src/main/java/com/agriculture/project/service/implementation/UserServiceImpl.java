package com.agriculture.project.service.implementation;


import com.agriculture.project.dto.UserDto;
import com.agriculture.project.mapper.UserMapper;
import com.agriculture.project.model.User;
import com.agriculture.project.repository.UserRepository;
import com.agriculture.project.service.initialization.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public String deleteAccount() {

        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        User user = userRepository.findByEmail(username)
                .orElseThrow(() -> new RuntimeException("User not found with username: " + username));

        userRepository.delete(user);

        return "Account deleted successfully";
    }

    @Override
    public UserDto updateProfile(UserDto userDto) {

        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        User user = userRepository.findByEmail(username)
                .orElseThrow(() -> new RuntimeException("User not found with username: " + username));

        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setCity(userDto.getCity());
        user.setAddress(userDto.getAddress());
        user.setProvince(userDto.getProvince());
        user.setPostalCode(userDto.getPostalCode());
        user.setPhoneNumber(userDto.getPhoneNumber());

        userRepository.save(user);

        return userMapper.toUserDto(user);
    }
}
