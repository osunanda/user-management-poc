package com.usermanagementservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class Auth0UserResponse {

    private String email;
    private String name;
    private String user_id;
    private String created_at;
    private AppMetadata app_metadata;
    private Auth0Identity[] identities;

    public Auth0UserResponse() {}

    public Auth0UserResponse(String email, String name, String user_id, String created_at, AppMetadata app_metadata, Auth0Identity[] identities) {
        this.email = email;
        this.name = name;
        this.user_id = user_id;
        this.created_at = created_at;
        this.app_metadata = app_metadata;
        this.identities = identities;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String username) {
        this.name = username;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public AppMetadata getApp_metadata() {
        return app_metadata;
    }

    public void setApp_metadata(AppMetadata app_metadata) {
        this.app_metadata = app_metadata;
    }

    public Auth0Identity[] getIdentities() {
        return identities;
    }

    public void setIdentities(Auth0Identity[] identities) {
        this.identities = identities;
    }
}
