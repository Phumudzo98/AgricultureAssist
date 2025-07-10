package com.agriculture.project.mapper;


import com.agriculture.project.dto.UserDto;
import com.agriculture.project.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toUserDto(User user);

    User toUser(UserDto userDto);
}
