package com.example.oktademo.controller;

import com.example.oktademo.services.OktaTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class OktaController{

    @Autowired
    OktaTokenService oktaTokenService;

    @RequestMapping(value = "/token", method = RequestMethod.GET)
    public String getToken() throws Exception {
        return oktaTokenService.getAccessToken().toString();
    }

}
