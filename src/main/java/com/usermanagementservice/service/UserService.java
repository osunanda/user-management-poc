package com.usermanagementservice.service;

import com.gogoair.dashecosystem.usermanagementservice.dto.UserRequest;
import com.gogoair.dashecosystem.usermanagementservice.dto.UserResponse;

public interface UserService {
    UserResponse createUser(UserRequest userRequest);

    UserResponse updateUser(UserRequest userRequest);
}
