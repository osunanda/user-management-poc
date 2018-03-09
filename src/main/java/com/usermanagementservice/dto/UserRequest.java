package com.usermanagementservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties
public class UserRequest {

    private String email;
    private String password;
    private String name;
    private AppMetadata app_metadata;
    private List<TailAndPermissionIds> tailPermissions;

    public UserRequest() {}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public List<TailAndPermissionIds> getTailPermissions() {
        return tailPermissions;
    }

    public void setTailPermissions(List<TailAndPermissionIds> tailPermissions) {
        this.tailPermissions = tailPermissions;
    }
}
