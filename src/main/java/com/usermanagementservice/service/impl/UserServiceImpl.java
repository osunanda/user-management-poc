package com.usermanagementservice.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gogoair.dashecosystem.usermanagementservice.constants.Auth0Constants;
import com.gogoair.dashecosystem.usermanagementservice.dto.Auth0UserRequest;
import com.gogoair.dashecosystem.usermanagementservice.dto.Auth0UserResponse;
import com.gogoair.dashecosystem.usermanagementservice.dto.DashPermission;
import com.gogoair.dashecosystem.usermanagementservice.dto.DashUserPolicy;
import com.gogoair.dashecosystem.usermanagementservice.dto.TailPermission;
import com.gogoair.dashecosystem.usermanagementservice.dto.UserRequest;
import com.gogoair.dashecosystem.usermanagementservice.dto.UserResponse;
import com.usermanagementservice.restclient.Auth0RestClient;
import com.usermanagementservice.restclient.PolicyEngineRestClient;
import com.usermanagementservice.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private Auth0RestClient auth0RestClient;

    @Autowired
    private Auth0Constants auth0Constants;

    @Autowired
    private PolicyEngineRestClient policyEngineRestClient;

    @Override
    public UserResponse createUser(UserRequest userRequest) {
        Auth0UserRequest auth0UserRequest = new Auth0UserRequest(userRequest);
        auth0UserRequest.setConnection(auth0Constants.getUsernamePasswordConnection());
        Auth0UserResponse auth0UserResponse = auth0RestClient.createUser(auth0UserRequest);

        DashUserPolicy dashUserPolicy = new DashUserPolicy();
        dashUserPolicy.setUserId(auth0UserResponse.getEmail());
        List<TailPermission> tailPermissions = new ArrayList<>();
        userRequest.getTailPermissions().forEach(tailAndPermissionIds -> {
            List<String> permissionIds = tailAndPermissionIds.getPermissionIds();
            TailPermission tailPermission = new TailPermission();
            tailPermission.setTail(tailAndPermissionIds.getTail());
            List<DashPermission> userPermissions = new ArrayList<>();
            if (permissionIds != null) {
                permissionIds.forEach(permissionId -> {
                    DashPermission dashPermission = policyEngineRestClient.getPermission(permissionId);
                    if (dashPermission != null) {
                        userPermissions.add(dashPermission);
                    }
                });
            }
            tailPermission.setPermissions(userPermissions);
            tailPermissions.add(tailPermission);
        });

        dashUserPolicy.setTailPermissions(tailPermissions);
        policyEngineRestClient.createUserPolicy(dashUserPolicy);

        UserResponse userResponse = new UserResponse(auth0UserResponse);
        return userResponse;
    }

    @Override
    public UserResponse updateUser(UserRequest userRequest) {
        Auth0UserRequest auth0UserRequest = new Auth0UserRequest(userRequest);
        Auth0UserResponse auth0UserResponse = auth0RestClient.updateUser(auth0UserRequest);

        UserResponse userResponse = new UserResponse(auth0UserResponse);
        return userResponse;
    }
}
