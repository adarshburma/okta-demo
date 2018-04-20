package com.example.oktademo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//@EnableOAuth2Sso
@RestController
@SpringBootApplication
public class OktaDemoApplication {

	@RequestMapping(value = "/" , method = RequestMethod.GET)
	public String hello(){
		return "Hello World !!!";
	}

	public static void main(String[] args) {
		SpringApplication.run(OktaDemoApplication.class, args);
	}
}
