package com.cos.security1.config;

import com.cos.security1.config.oauth.PrincipalOauth2UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

// 1. 코드받기 (인증완료)
// 2. 액세스토큰 (접근권한)
// 3. 사용자 프로필 정보를 가져옴
// 4-1. 3번의 정보를 토대로 회원가입 자동 진행
// 4-2. 3번의 정보 이외의 추가적인 정보가 필요할 경우 추가정보 입력창 필요

@Configuration
@EnableWebSecurity // 스프링 시큐리티 필터를 스프링 필터체인에 등록
@EnableGlobalMethodSecurity(securedEnabled = true       // secured 어노테이션 활성화
                            , prePostEnabled = true)    // preAuthorize, postAuthorize 어노테이션 활성화
public class SecurityConfig {

    @Autowired
    private PrincipalOauth2UserService principalOauth2UserService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/user/**").authenticated()
                .antMatchers("/manager/**").access("hasAnyRole('ROLE_ADMIN', 'ROLE_MANAGER')")
                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                .anyRequest().permitAll()

                .and()
                .formLogin()
                .loginPage("/loginForm")
                .loginProcessingUrl("/login") // "/login" 주소가 호출되면 시큐리티가 낚아채 대신 로그인을 진행 (/login mapping을 하지 않아도 시큐리티가 만들어둔 로그인페이지로 이동)
                .defaultSuccessUrl("/")

                .and()
                .oauth2Login()
                .loginPage("/loginForm") // Tip : 구글로그인 완료 시 (액세스 토큰 + 사용자 프로필 정보) 가 넘어옴 (코드X)
                .userInfoEndpoint()
                .userService(principalOauth2UserService)
        ;

        return http.build();
    }

}
