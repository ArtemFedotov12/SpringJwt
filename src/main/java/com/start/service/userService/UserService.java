package com.start.service.userService;

import com.start.model.entities.User;
import com.start.model.dto.UserDto;

import java.util.List;

public interface UserService {

    User save(UserDto user);
    List<User> findAll();
    void delete(long id);
    User findOne(String username);

    User findById(Long id);
}
