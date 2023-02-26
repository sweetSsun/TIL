package com.cos.jwt.config;

import lombok.RequiredArgsConstructor;
import org.apache.catalina.filters.CorsFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final CorsConfig corsConfig;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()
                        .addFilter(corsConfig.corsFilter()) // 인증이 필요할 때는 필터에 등록, 인증이 필요없을 때는 @CrossOrigin으로 해결 가능
                        .formLogin().disable()
                        .httpBasic().disable()

                .authorizeRequests()
                        .antMatchers("/api/v1/user/**")
                        .access("hasAnyRole('ROLE_USER', 'ROLE_MANAGER', 'ROLE_ADMIN')")
                        .antMatchers("/api/v1/manager/**")
                        .access("hasAnyRole('ROLE_MANAGER', 'ROLE_ADMIN')")
                        .antMatchers("/api/v1/admin/**")
                        .access("hasRole('ROLE_ADMIN')")
                        .anyRequest().permitAll();

        return http.build();
    }

}
