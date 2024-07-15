package io.nology.drawn_together_backend.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Autowired
    private UserAuthService userAuthService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    @Bean
    // We need to be able to use our custom UserDetailsService and
    // BCryptPasswordEncoder with the AuthenticationManager
    AuthenticationManager authenticationManager(HttpSecurity httpSecurity) throws Exception {
        // AuthenticationManager is a Spring Security interface that provides the core
        // authentication logic
        // httpSecurity is a builder object that allows for configuring the security of
        // the application
        // From the httpSecurity object, we can get the AuthenticationManagerBuilder
        // object
        AuthenticationManagerBuilder authenticationManagerBuilder = httpSecurity
                .getSharedObject(AuthenticationManagerBuilder.class);
        // We then configure the AuthenticationManagerBuilder object to use the
        // UserDetailsService and BCryptPasswordEncoder
        authenticationManagerBuilder.userDetailsService(userAuthService).passwordEncoder(passwordEncoder);
        return authenticationManagerBuilder.build();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/**").permitAll() // Allow unauthenticated access to /auth/** endpoints
                        .anyRequest().authenticated())
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
        return httpSecurity.build();
    }
}
