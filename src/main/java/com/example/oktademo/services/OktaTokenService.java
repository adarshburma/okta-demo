package com.example.oktademo.services;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import feign.Util;
import feign.Response;
import com.example.oktademo.config.OAuthConfig;
import org.springframework.stereotype.Service;
import org.json.JSONObject;
import org.json.JSONTokener;



@Service
public class OktaTokenService {

    @Autowired
    OktaTokenProxy oktaTokenProxy;

    @Autowired
    OktaRefreshTokenProxy oktaRefreshTokenProxy;

    @Autowired
    OAuthConfig oAuthConfig;


    public String getRefreshToken() throws Exception{
        Response response = oktaRefreshTokenProxy
                .getRefreshToken(generateBase64Token(), "password", oAuthConfig.getUsername(), oAuthConfig.getPassword(), oAuthConfig.getScope());
        String responseBody = Util.toString(response.body().asReader());
        JSONObject json = (JSONObject) new JSONTokener(responseBody).nextValue();
        return json.getString("refresh_token"); // this returns the access_code
    }


    public String getAccessToken() throws Exception{
        String refreshToken = this.getRefreshToken();
        Response response = oktaTokenProxy
                .getAccessToken(generateBase64Token(), "refresh_token", refreshToken , oAuthConfig.getScope());
        String responseBody = Util.toString(response.body().asReader());
        JSONObject json = (JSONObject) new JSONTokener(responseBody).nextValue();
        return json.getString("access_token"); // this returns the access_token
    }


    private String generateBase64Token() {
        String authString = oAuthConfig.getClientId() + ":" + oAuthConfig.getClientSecret();
        return "Basic " + Base64.encodeBase64String(authString.getBytes());
    }
}
