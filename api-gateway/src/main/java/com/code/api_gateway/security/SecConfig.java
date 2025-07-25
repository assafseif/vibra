package com.code.api_gateway.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

import com.code.api_gateway.security.jwt.AuthEntryPointJwt;
import com.code.api_gateway.security.jwt.AuthTokenFilter;

@Configuration
@EnableMethodSecurity
public class SecConfig {

    @Autowired
    private AuthEntryPointJwt unauthorizedHandler;

    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter() {
        return new AuthTokenFilter();
    }

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        return http.csrf(csrf -> csrf.disable())
                .exceptionHandling(exception -> exception.authenticationEntryPoint(unauthorizedHandler))
                .authorizeExchange(auth -> auth
                        .pathMatchers("/auth/login", "/auth/register", "/actuator/health").permitAll()
                        .anyExchange().authenticated())
                .addFilterBefore(authenticationJwtTokenFilter(), SecurityWebFiltersOrder.AUTHENTICATION)
                .build();
    }

}
