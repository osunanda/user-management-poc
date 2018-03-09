package com.usermanagementservice.constants;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@PropertySource({"classpath:auth0.properties"})
@Component
public class Auth0Constants {

    @Value("${com.auth0.api.audience}")
    private String apiAudience;

    @Value("${com.auth0.non-interactive-client-id}")
    private String nonInteractiveClientId;

    @Value("${com.auth0.non-interactive-client-secret}")
    private String nonInteractiveClientSecret;

    @Value("${com.auth0.connection.username-password}")
    private String usernamePasswordConnection;

    @Value("${com.auth0.api.url.users}")
    private String usersApiUrl;

    @Value("${com.auth0.api.url.token}")
    private String tokenApiUrl;

    @Value("${com.auth0.non-interactive-client.grant-type}")
    private String nonInteractiveClientGrantType;

    public String getApiAudience() {
        return apiAudience;
    }

    public String getNonInteractiveClientId() {
        return nonInteractiveClientId;
    }

    public String getNonInteractiveClientSecret() {
        return nonInteractiveClientSecret;
    }

    public String getUsernamePasswordConnection() {
        return usernamePasswordConnection;
    }

    public String getUsersApiUrl() {
        return usersApiUrl;
    }

    public String getTokenApiUrl() {
        return tokenApiUrl;
    }

    public String getNonInteractiveClientGrantType() {
        return nonInteractiveClientGrantType;
    }
}
