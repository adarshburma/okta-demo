package com.example.oktademo.config;

import feign.Feign;
import feign.form.FormEncoder;
import com.example.oktademo.services.OktaTokenProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OktaTokenProxyConfig {

    @Bean
    public OktaTokenProxy oktaAccessTokenProxy() {
        return Feign.builder()
                .encoder(new FormEncoder())
                .target(OktaTokenProxy.class,
                        "https://dev-978191.oktapreview.com/oauth2/ausertyr58t13JgrD0h7/v1/token");
                       // "https://iheartmedia.oktapreview.com/oauth2/ausdxg7kqcREWHfeT0h7/v1/token");
    }

}