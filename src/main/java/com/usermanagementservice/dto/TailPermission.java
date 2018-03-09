package com.usermanagementservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties
public class TailPermission {
    private String tail;
    private List<DashPermission> permissions;

    public String getTail() {
        return tail;
    }

    public void setTail(String tail) {
        this.tail = tail;
    }

    public List<DashPermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<DashPermission> permissions) {
        this.permissions = permissions;
    }
}
