// package com.testproject.swp.security;

// import org.apache.catalina.filters.CorsFilter;
// import org.springframework.boot.web.servlet.FilterRegistrationBean;
// import org.springframework.context.annotation.Bean; 
// import org.springframework.context.annotation.Configuration;
// import org.springframework.web.cors.CorsConfiguration;
// import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

// @Configuration
// public class CorsOriginConfig {
//     @Bean
//     public FilterRegistrationBean corsFilter() {
//         UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//         CorsConfiguration config = new CorsConfiguration();
//         config.setAllowCredentials(Boolean.TRUE);
//         config.addAllowedHeader(CorsConfiguration.ALL);
//         config.addAllowedOrigin(CorsConfiguration.ALL);
//         config.addAllowedMethod(CorsConfiguration.ALL);
//         source.registerCorsConfiguration("/**", config);
//         FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter());
//         bean.setOrder(0);
//         return bean;
//     }

// }
