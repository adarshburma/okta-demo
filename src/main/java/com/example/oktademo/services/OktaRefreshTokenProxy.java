package com.example.oktademo.services;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import feign.Response;

public interface OktaRefreshTokenProxy {

    @RequestLine("POST /")
    @Headers({
            "Content-Type: application/x-www-form-urlencoded",
            "Authorization: {token}"
    })
    Response getRefreshToken(@Param("token") String token,
                            @Param("grant_type") String grantType,
                            @Param("username") String username,
                            @Param("password") String password,
                            @Param("scope") String scope);

}
