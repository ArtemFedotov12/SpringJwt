package com.start.model.converter;

import com.start.model.dto.PermissionDto;
import com.start.model.dto.UserDto;
import com.start.model.entities.Permission;
import com.start.model.entities.User;

import static java.util.Optional.ofNullable;

public class UserConverter implements IConverter<User, UserDto>{
    @Override
    public User toEntity(UserDto userDto) {
        return ofNullable(userDto)
                .map(item -> {
                    User user = new User();
                    user.setUsername(item.getUsername());
                    user.setPassword(item.getPassword());
                    user.setAge(item.getAge());
                    user.setSalary(item.getSalary());
                    return user;
                })
                .orElse(null);
    }

    @Override
    public UserDto toDto(User user) {
        return ofNullable(user)
                .map(item -> {
                    UserDto userDto = new UserDto();
                    userDto.setUsername(item.getUsername());
                    userDto.setPassword(item.getPassword());
                    userDto.setAge(item.getAge());
                    userDto.setSalary(item.getSalary());
                    return userDto;
                })
                .orElse(null);
    }
}
