package com.cos.jwt.config;

import com.cos.jwt.jwt.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final CorsConfig corsConfig;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.addFilterBefore(new MyFilter3(), SecurityContextPersistenceFilter.class); // 직접 생성한 FilterConfig보다 SecurityFilterChain이 먼저 실행됨

        http.csrf().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)

            .and()
                    .addFilter(corsConfig.corsFilter()) // 인증이 필요할 때는 필터에 등록, 인증이 필요없을 때는 @CrossOrigin으로 해결 가능
                    .formLogin().disable()
                    .httpBasic().disable() // Bearer 인증방식을 사용하기 위해 Basic을 disable 처리 (Basic은 ID/PW를 들고오는 방식, Bearer는 TOKEN을 들고오는 방식)
                    .apply(new MyCustomDsl()) // custom Filter 등록

            .and()
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

    public class MyCustomDsl extends AbstractHttpConfigurer<MyCustomDsl, HttpSecurity> {
        @Override
        public void configure(HttpSecurity http) throws Exception {
            AuthenticationManager authenticationManager = http.getSharedObject(AuthenticationManager.class);
            http
                    .addFilter(corsConfig.corsFilter())
                    .addFilter(new JwtAuthenticationFilter(authenticationManager));
        }
    }

}
