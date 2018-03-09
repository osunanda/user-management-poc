package com.usermanagementservice.config;

import com.auth0.spring.security.api.JwtWebSecurityConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
@PropertySource({"classpath:auth0.properties"})
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Value(value = "${com.auth0.apiAudience}")
    private String apiAudience;

    @Value(value = "${com.auth0.issuer}")
    private String issuer;

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        JwtWebSecurityConfigurer
                .forRS256(apiAudience, issuer)
                .configure(httpSecurity)
                .csrf().disable()
                .cors().and()
                .authorizeRequests()
                .antMatchers("*").permitAll();
        //httpSecurity.csrf().disable().authorizeRequests().antMatchers("*").permitAll();
    }
}
