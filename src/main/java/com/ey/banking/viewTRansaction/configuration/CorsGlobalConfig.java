package com.ey.banking.viewTRansaction.configuration;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
@Data
@Configuration
public class CorsGlobalConfig {

    @Value("${corsUrl}")
    private String corsUrl;
    @Bean
    public CorsWebFilter corsWebFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin(corsUrl); // your frontend origin
        config.addAllowedMethod("*"); // allow all HTTP methods (GET, POST, etc.)
        config.addAllowedHeader("*"); // allow all headers
        config.setAllowCredentials(true); // if you need cookies/auth

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return new CorsWebFilter(source);
    }
}
