package com.example.oktademo.services;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import feign.Response;

/**
 * Proxy for okta tokens.
 */
public interface OktaTokenProxy {

    @RequestLine("POST /")
    @Headers({
            "Accept: application/json",
            "Content-Type: application/x-www-form-urlencoded",
            "Authorization: {token}"
    })
    Response getAccessToken(@Param("token") String token,
                            @Param("grant_type") String grantType,
                            @Param("refresh_token") String refreshToken,
                            @Param("scope") String scope);

}