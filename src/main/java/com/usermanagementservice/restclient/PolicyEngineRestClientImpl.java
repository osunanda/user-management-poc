package com.usermanagementservice.restclient;

import com.gogoair.dashecosystem.usermanagementservice.constants.DashConstants;
import com.gogoair.dashecosystem.usermanagementservice.dto.DashPermission;
import com.gogoair.dashecosystem.usermanagementservice.dto.DashUserPolicy;
import com.gogoair.dashecosystem.usermanagementservice.restclient.AbstractRestClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PolicyEngineRestClientImpl extends AbstractRestClient implements PolicyEngineRestClient {

    @Autowired
    private DashConstants dashConstants;
    @Override
    public DashUserPolicy createUserPolicy(DashUserPolicy dashUserPolicy) {
        HttpEntity<DashUserPolicy> httpEntity = new HttpEntity<>(dashUserPolicy, prepareHttpHeaders());
        DashUserPolicy userPolicy = restTemplate.postForObject(dashConstants.getUserPolicyApiUrl(), httpEntity, DashUserPolicy.class);
        return userPolicy;
    }

    @Override
    public DashPermission getPermission(String permissionId) {
        DashPermission dashPermission = restTemplate.getForObject(dashConstants.getPermissionApiUrl() + "/" + permissionId, DashPermission.class);
        return dashPermission;
    }

    @Override
    public DashUserPolicy updateUserPolicy(DashUserPolicy userPolicy) {
        HttpEntity<DashUserPolicy> httpEntity = new HttpEntity<>(userPolicy, prepareHttpHeaders());
        ResponseEntity<DashUserPolicy> userPolicyResponseEntity = restTemplate.exchange(dashConstants.getUserPolicyApiUrl(), HttpMethod.PUT, httpEntity, DashUserPolicy.class);
        return userPolicyResponseEntity.getBody();
    }
}
