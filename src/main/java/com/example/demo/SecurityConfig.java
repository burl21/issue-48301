package com.example.demo;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

import org.springframework.boot.security.oauth2.server.resource.autoconfigure.servlet.JwkSetUriJwtDecoderBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration(proxyBeanMethods = false)
class SecurityConfig {

  @Bean
  SecurityFilterChain filterChainApi(HttpSecurity http) {
    return http.csrf(AbstractHttpConfigurer::disable)
        .formLogin(AbstractHttpConfigurer::disable)
        .logout(AbstractHttpConfigurer::disable)
        .anonymous(AbstractHttpConfigurer::disable)
        .authorizeHttpRequests(c -> c.anyRequest().authenticated())
        .sessionManagement(sess -> sess.sessionCreationPolicy(STATELESS))
        .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()))
        .build();
  }

  @Bean
  JwkSetUriJwtDecoderBuilderCustomizer atJwtDecoderBuilderCustomizer() {
    return builder -> builder.validateType(false);
  }
}
