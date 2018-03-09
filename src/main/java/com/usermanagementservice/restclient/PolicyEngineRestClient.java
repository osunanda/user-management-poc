package com.usermanagementservice.restclient;

import com.gogoair.dashecosystem.usermanagementservice.dto.DashPermission;
import com.gogoair.dashecosystem.usermanagementservice.dto.DashUserPolicy;

public interface PolicyEngineRestClient {
    DashUserPolicy createUserPolicy(DashUserPolicy userPolicy);
    DashPermission getPermission(String permissionId);
    DashUserPolicy updateUserPolicy(DashUserPolicy userPolicy);
}
