package com.start.controller;

import com.start.model.dto.UserDto;
import com.start.model.entities.User;
import com.start.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@Api(value = "UserController", description = "Controller for interaction with user")
public class UserController {

    private final UserService userService;

    //@Secured({"ROLE_ADMIN", "ROLE_USER"})
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/users")
    public List<User> listUser() {
        return userService.findAll();
    }

    //@Secured("ROLE_USER")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @ApiOperation(
            value = "Find by id",
            notes = "The method allows you to search for an object by a unique identifier"
    )
    @GetMapping("/users/{id}")
    public User getOne(@PathVariable(value = "id") Long id) {
        return userService.findById(id);
    }


    @PostMapping("/signup")
    public User saveUser(@RequestBody UserDto user) {
        return userService.save(user);
    }



}
