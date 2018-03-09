package com.usermanagementservice.restclient;

import com.gogoair.dashecosystem.usermanagementservice.dto.Auth0UserRequest;
import com.gogoair.dashecosystem.usermanagementservice.dto.Auth0UserResponse;
import com.gogoair.dashecosystem.usermanagementservice.restclient.AbstractRestClient;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;

@Service
public class Auth0RestClientImpl extends AbstractRestClient implements Auth0RestClient {

    @Override
    public Auth0UserResponse createUser(Auth0UserRequest userRequest) {
        HttpEntity<Auth0UserRequest> httpEntity = new HttpEntity<>(userRequest, prepareHttpHeaders());
        Auth0UserResponse userResponse = restTemplate.postForObject(auth0Constants.getUsersApiUrl(), httpEntity, Auth0UserResponse.class);
        return userResponse;
    }

    @Override
    public Auth0UserResponse updateUser(Auth0UserRequest userRequest) {
        HttpEntity<Auth0UserRequest> httpEntity = new HttpEntity<>(userRequest, prepareHttpHeaders());
        Auth0UserResponse userResponse = restTemplate.patchForObject(auth0Constants.getUsersApiUrl(), httpEntity, Auth0UserResponse.class);
        return userResponse;
    }


}
