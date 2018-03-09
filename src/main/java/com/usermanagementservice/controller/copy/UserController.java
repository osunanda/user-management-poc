package com.usermanagementservice.controller.copy;

import com.gogoair.dashecosystem.usermanagementservice.dto.UserRequest;
import com.gogoair.dashecosystem.usermanagementservice.dto.UserResponse;

public interface UserController {
    UserResponse createUser(UserRequest userRequest);
    UserResponse updateUser(UserRequest userRequest);
}
