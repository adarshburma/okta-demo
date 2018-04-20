package com.example.oktademo.config;


import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class OAuthConfig {

    @Value("${security.oauth2.client.clientId}")
    private String clientId;

    @Value("${security.oauth2.client.clientSecret}")
    private String clientSecret;

    @Value("${security.oauth2.client.scope}")
    private String scope;

    @Value("${username}")
    private String username;

    @Value("${password}")
    private String password;

    @Value("${refreshtoken}")
    private String refreshtoken;

}

