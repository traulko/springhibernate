package com.innowise.springhibernate.controller;

import com.innowise.springhibernate.dto.UserDto;
import com.innowise.springhibernate.dto.UserRoleDto;
import com.innowise.springhibernate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void add(@RequestBody final UserDto userDto) {
        userService.add(userDto);
    }

    @PostMapping("/role")
    public void addRole(@RequestBody final UserRoleDto userRoleDto) {
        userService.addRole(userRoleDto);
    }

    @PostMapping("{id}/role/{roleId}")
    public void addRoleToUser(@PathVariable final Long id, @PathVariable final Long roleId) {
        userService.addUserRoleToUser(id, roleId);
    }
}
