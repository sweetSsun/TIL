package com.cos.security1.config.oauth;

import com.cos.security1.config.auth.PrincipalDetails;
import com.cos.security1.model.User;
import com.cos.security1.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;


@Service
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {

    private static final Logger logger = LoggerFactory.getLogger(PrincipalOauth2UserService.class);

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;

    // 구글로부터 받은 userRequest 데이터에 대한 후처리 함수
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        logger.info("[PrincipalOauth2UserService][loadUser] getClientRegistration : {}, getTokenValue : {}"
                , userRequest.getClientRegistration(), userRequest.getAccessToken().getTokenValue()); // registrationId로 어떤 Oauth인지 확인 가능

        OAuth2User oAuth2User = super.loadUser(userRequest);
        // 구글 로그인 버튼 -> 구글 로그인 창 -> 로그인 완료 -> code 리턴(Oauth-Client 라이브러리) -> AccessToken 요청/응답
        // usrRequest 정보 -> loadUser 함수 호출 : 회원 프로필 요청/응답
        logger.info("[PrincipalOauth2UserService][loadUser] getAttributes : {}", oAuth2User.getAttributes());

        String provider = userRequest.getClientRegistration().getRegistrationId(); // google
        String providerId = oAuth2User.getAttribute("sub");
        String username = provider + "_" + providerId;
        String password = bCryptPasswordEncoder.encode("겟인데어");
        String email = oAuth2User.getAttribute("email");
        String role = "ROLE_USER";

        User userEntity = userRepository.findByUsername(username).orElse(null);
        if (userEntity == null) {
            userEntity = User.builder()
                    .provider(provider)
                    .providerId(providerId)
                    .username(username)
                    .password(password)
                    .email(email)
                    .role(role)
                    .build();
            userRepository.save(userEntity);
        }

        return new PrincipalDetails(userEntity, oAuth2User.getAttributes());
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