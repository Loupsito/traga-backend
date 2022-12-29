package com.loupsito.traga.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/v3/api-docs","/v3/api-docs/swagger-config", "/swagger-resources/configuration/ui", "/swagger-resources", "/swagger-resources/configuration/security", "/swagger-ui.html","/swagger-ui/index.html", "/webjars/**").permitAll()
                .and()
                .authorizeRequests(expressionInterceptUrlRegistry -> expressionInterceptUrlRegistry
                        .anyRequest().authenticated().and())
                .oauth2ResourceServer().jwt();
        return http.build();
    }
}