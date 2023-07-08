package com.testproject.swp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfiguration {

    private final JwtRequestFilter jwtRequestFilter;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable().authorizeRequests()
                // thằng có url này không cần đăng nhập
                .antMatchers("/api/ccg1/login").permitAll()
                .antMatchers("/api/ccg1/users/**").permitAll()
                .antMatchers("/api/ccg1/user").permitAll()
                .antMatchers("/api/ccg1/reservations").permitAll()
                .antMatchers("/api/ccg1/addReservation").permitAll()
                .antMatchers("/api/ccg1/reservation/**").permitAll()
                .antMatchers("/api/ccg1/roles").permitAll()
                .antMatchers("/api/ccg1/deleteUser/**").permitAll()
                // chỉ cho method post truy cập
                .antMatchers(HttpMethod.POST, "/api/ccg1/register").permitAll()
                // bắt buộc đăng nhập
                .antMatchers("/api/ccg1/**").authenticated()
                .and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
        return httpSecurity.build();
    }
}