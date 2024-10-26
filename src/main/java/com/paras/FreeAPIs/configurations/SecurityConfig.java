package com.paras.FreeAPIs.configurations;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfig {
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
        http
                .cors(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(req ->
                                               req.requestMatchers(
                                                          "/**",
                                                          "/v2/api/docs",
                                                          "/v3/api/docs",
                                                          "/v3/**",
                                                          "/v3/api/docs/**",
                                                          "/swagger/resources",
                                                          "/swagger/resources/**",
                                                          "/configuration/ui",
                                                          "/configuration/security",
                                                          "/swagger-ui.html",
                                                          "/swagger-ui/**",
                                                          "/webjars/**"
                                                                  )
                                                  .permitAll()
                                                  .anyRequest()
                                                  .authenticated())
                .sessionManagement(session ->
                                           session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider);
        return http.build();
    }
}
