package com.usermanagementservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties
public class DashUserPolicy {
    private String userId;
    private List<TailPermission> tailPermissions;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<TailPermission> getTailPermissions() {
        return tailPermissions;
    }

    public void setTailPermissions(List<TailPermission> tailPermissions) {
        this.tailPermissions = tailPermissions;
    }
}
