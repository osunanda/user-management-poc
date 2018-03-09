package com.usermanagementservice.constants;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DashConstants {

    @Value("${com.gogoair.dashecosystem.policy-engine.policy.url.user-policy}")
    private String userPolicyApiUrl;

    @Value("${com.gogoair.dashecosystem.policy-engine.policy.url.permission}")
    private String permissionApiUrl;

    public String getUserPolicyApiUrl() {
        return userPolicyApiUrl;
    }

    public String getPermissionApiUrl() {
        return permissionApiUrl;
    }
}
