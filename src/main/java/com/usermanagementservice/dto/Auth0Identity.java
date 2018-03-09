package com.usermanagementservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class Auth0Identity {

    private String connection;
    private String user_id;
    private String provider;
    private boolean isSocial;

    public Auth0Identity() {}

    public Auth0Identity(String connection, String user_id, String provider, boolean isSocial) {
        this.connection = connection;
        this.user_id = user_id;
        this.provider = provider;
        this.isSocial = isSocial;
    }

    public String getConnection() {
        return connection;
    }

    public void setConnection(String connection) {
        this.connection = connection;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public boolean isSocial() {
        return isSocial;
    }

    public void setSocial(boolean social) {
        isSocial = social;
    }
}
