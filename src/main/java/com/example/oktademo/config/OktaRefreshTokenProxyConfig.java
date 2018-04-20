package com.example.oktademo.config;

import com.example.oktademo.services.OktaRefreshTokenProxy;
import feign.Feign;
import feign.form.FormEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OktaRefreshTokenProxyConfig {
    @Bean
    public OktaRefreshTokenProxy oktaRefreshTokenProxy() {
        return Feign.builder()
                .encoder(new FormEncoder())
                .target(OktaRefreshTokenProxy.class,
                        "https://dev-978191.oktapreview.com/oauth2/ausertyr58t13JgrD0h7/v1/token");
        // "https://iheartmedia.oktapreview.com/oauth2/ausdxg7kqcREWHfeT0h7/v1/authorize");
    }
}
