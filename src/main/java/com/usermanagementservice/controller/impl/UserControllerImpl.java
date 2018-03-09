package com.usermanagementservice.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gogoair.dashecosystem.usermanagementservice.aspect.annotation.Authorize;
import com.gogoair.dashecosystem.usermanagementservice.controller.UserController;
import com.gogoair.dashecosystem.usermanagementservice.dto.UserRequest;
import com.gogoair.dashecosystem.usermanagementservice.dto.UserResponse;
import com.gogoair.dashecosystem.usermanagementservice.service.UserService;

@RestController
public class UserControllerImpl implements UserController {

    @Autowired
    private UserService userService;

    @Override
    @Authorize(scopes = {"user:*", "user:create"}, roles = {"SUPER_ADMIN", "ADMIN"})
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public UserResponse createUser(@RequestBody UserRequest userRequest) {
        return userService.createUser(userRequest);
    }

    @Override
    @Authorize(scopes = {"user:*", "user:update"}, roles = {"SUPER_ADMIN", "ADMIN"})
    @RequestMapping(value = "/users", method = RequestMethod.PATCH)
    public UserResponse updateUser(UserRequest userRequest) {
        return userService.updateUser(userRequest);
    }
}
