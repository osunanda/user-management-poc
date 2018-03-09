package com.usermanagementservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class Auth0UserRequest {
    private String connection;
    private String email;
    private String password;
    private String name;
    private AppMetadata app_metadata;

    public Auth0UserRequest() {}

    public Auth0UserRequest(UserRequest userRequest) {
        this.email = userRequest.getEmail();
        this.password = userRequest.getPassword();
        this.name = userRequest.getName();
        this.app_metadata = userRequest.getApp_metadata();
    }

    public String getConnection() {
        return connection;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setConnection(String connection) {
        this.connection = connection;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
