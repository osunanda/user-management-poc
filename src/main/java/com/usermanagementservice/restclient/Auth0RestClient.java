package com.usermanagementservice.restclient;

import com.usermanagementservice.dto.Auth0UserRequest;
import com.usermanagementservice.dto.Auth0UserResponse;

public interface Auth0RestClient {
    Auth0UserResponse createUser(Auth0UserRequest userRequest);

    Auth0UserResponse updateUser(Auth0UserRequest userRequest);
}
