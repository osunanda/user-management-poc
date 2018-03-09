package com.usermanagementservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class UserResponse {

    private String email;
    private String user_id;
    private String name;
    private AppMetadata app_metadata;

    public UserResponse() {}

    public UserResponse(Auth0UserResponse userResponse) {
        email = userResponse.getEmail();
        user_id = userResponse.getUser_id();
        name = userResponse.getName();
        app_metadata = userResponse.getApp_metadata();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public AppMetadata getApp_metadata() {
        return app_metadata;
    }

    public void setApp_metadata(AppMetadata app_metadata) {
        this.app_metadata = app_metadata;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
