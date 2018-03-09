package com.usermanagementservice.aspect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.gogoair.dashecosystem.usermanagementservice.aspect.annotation.Authorize;
import com.gogoair.dashecosystem.usermanagementservice.dto.DashOrg;
import com.gogoair.dashecosystem.usermanagementservice.exception.UnauthorizedAccessException;

@Aspect
@Component
public class UserManagementAuthorizationAspect {

    @Pointcut("@annotation(authorize)")
    public void annotatedWithAuthorize(Authorize authorize) {
    }

    @Before("annotatedWithAuthorize(authorize)")
    public void authorizeUserWithRoles(Authorize authorize) {
        List<String> methodRoles = Arrays.asList(authorize.roles());
        if (methodRoles.isEmpty() || !hasRoles(methodRoles, getUserRoles(getUserDetail()))) {
            throw new UnauthorizedAccessException("Unauthorized to access this resource");
        }
    }

    private JWTUserDetail getUserDetail() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        String authorizationHeader = request.getHeader("Authorization");
        if (StringUtils.isEmpty(authorizationHeader)) {
            throw new UnauthorizedAccessException("Unauthorized to access this resource!");
        }
        String token = authorizationHeader.substring(7);
        DecodedJWT decodedJWT = null;
        try {
            decodedJWT = JWT.decode(token);
        } catch (JWTDecodeException ex) {
            ex.printStackTrace();
        }

        JWTUserDetail userDetail = new JWTUserDetail();
        userDetail.setEmail(decodedJWT.getClaim("email").asString());
        List<DashOrg> orgIds = decodedJWT.getClaim("https://dash.gogoair.com/orgIds").asList(DashOrg.class);
        userDetail.setOrgIds(orgIds);

        return userDetail;
    }

    private List<String> getUserRoles(JWTUserDetail userDetail) {
        List<String> userRoles = new ArrayList<>();
        userDetail.getOrgIds().forEach(orgId -> {
            userRoles.add(orgId.getRole());
        });

        return userRoles;
    }

    private boolean hasRoles(List<String> methodRoles, List<String> userRoles) {
        if (methodRoles != null && !methodRoles.isEmpty() && !userRoles.isEmpty()) {
            String matchedUserRole = methodRoles.stream()
                    .filter(methodRole -> {
                        String matchedRole = userRoles.stream().filter(userRole -> userRole.equalsIgnoreCase("*") || userRole.equalsIgnoreCase(methodRole))
                                .findFirst().get();
                        return !StringUtils.isEmpty(matchedRole);
                    })
                    .findFirst().get();

            if (!StringUtils.isEmpty(matchedUserRole)) {
                return true;
            }
        }
        return false;
    }

    private class JWTUserDetail {
        String email;
        List<DashOrg> orgIds;

        String getEmail() {
            return email;
        }

        void setEmail(String email) {
            this.email = email;
        }

        List<DashOrg> getOrgIds() {
            return orgIds;
        }

        void setOrgIds(List<DashOrg> orgIds) {
            this.orgIds = orgIds;
        }
    }
}
