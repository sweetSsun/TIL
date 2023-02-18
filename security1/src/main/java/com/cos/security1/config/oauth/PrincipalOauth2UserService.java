package com.cos.security1.config.oauth;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {

    // 구글로부터 받은 userRequest 데이터에 대한 후처리 함수
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        System.out.println("getClientRegistration∂ : " + userRequest.getClientRegistration());
        System.out.println("getClientRegistration : " + userRequest.getAccessToken().getTokenValue());
        System.out.println("getAttributes : " + super.loadUser(userRequest).getAttributes());
        return super.loadUser(userRequest);
    }
    /**
     * super.loadUser(userRequest).getAttributes() =
     * {sub=103774520920990623404
     * , name=김지선
     * , given_name=지선
     * , family_name=김
     * , picture=https://lh3.googleusercontent.com/a/AEdFTp7Gr9CLZakg_HHzy_mCcskZSAsbKwRt2F8N-GqOVQ=s96-c
     * , email=nalong77@gmail.com
     * , email_verified=true
     * , locale=ko}
     */
}
