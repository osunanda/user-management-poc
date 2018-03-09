package com.usermanagementservice.restclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.gogoair.dashecosystem.usermanagementservice.constants.Auth0Constants;
import com.gogoair.dashecosystem.usermanagementservice.dto.AppTokenRequest;
import com.gogoair.dashecosystem.usermanagementservice.dto.AppTokenResponse;

@Component
public class AbstractRestClient {

    @Autowired
    protected Auth0Constants auth0Constants;

    @Autowired
    protected RestTemplate restTemplate;

    private AppTokenResponse getToken() {
        // If this wasn't a POC, we would obviously try not to authenticate unless the token expires ;)
        AppTokenRequest appTokenRequest = new AppTokenRequest();
        appTokenRequest.setGrant_type(auth0Constants.getNonInteractiveClientGrantType());
        appTokenRequest.setClient_id(auth0Constants.getNonInteractiveClientId());
        appTokenRequest.setClient_secret(auth0Constants.getNonInteractiveClientSecret());
        appTokenRequest.setAudience(auth0Constants.getApiAudience());

        AppTokenResponse appTokenResponse = restTemplate.postForObject(auth0Constants.getTokenApiUrl(), appTokenRequest, AppTokenResponse.class);
        return appTokenResponse;
    }

    protected HttpHeaders prepareHttpHeaders() {
        AppTokenResponse appTokenResponse = getToken();
        StringBuilder authorizationHeader = new StringBuilder();
        authorizationHeader.append(appTokenResponse.getToken_type());
        authorizationHeader.append(" ");
        authorizationHeader.append(appTokenResponse.getAccess_token());

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", authorizationHeader.toString());
        return headers;
    }
}
