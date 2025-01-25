package com.example.springbootpractice.common.config;

import com.example.springbootpractice.common.exception.CustomAccessDeniedHandler;
import com.example.springbootpractice.common.exception.CustomAuthenticationEntryPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final CustomAccessDeniedHandler accessDeniedHandler;
    private final CustomAuthenticationEntryPoint authenticationEntryPoint;

    public SecurityConfig(CustomAccessDeniedHandler accessDeniedHandler,
        CustomAuthenticationEntryPoint authenticationEntryPoint) {
        this.accessDeniedHandler = accessDeniedHandler;
        this.authenticationEntryPoint = authenticationEntryPoint;
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(AbstractHttpConfigurer::disable);
        httpSecurity.httpBasic(HttpBasicConfigurer::disable);
        httpSecurity.sessionManagement(
            session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        httpSecurity.authorizeHttpRequests(authorizeHttpRequests -> {
            authorizeHttpRequests.requestMatchers("/").permitAll();
            authorizeHttpRequests.requestMatchers("/actuator/**").permitAll();
            authorizeHttpRequests.anyRequest().authenticated();
        });

        httpSecurity.exceptionHandling(handler -> {
            handler.accessDeniedHandler(accessDeniedHandler);
            handler.authenticationEntryPoint(authenticationEntryPoint);
        });

        return httpSecurity.build();
    }
}
