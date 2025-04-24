package dev.tts.learning.spring_security.service;

import dev.tts.learning.spring_security.model.UserEntity;
import dev.tts.learning.spring_security.model.UserInfoEntity;
import dev.tts.learning.spring_security.model.enums.Role;
import dev.tts.learning.spring_security.repository.UserInfoRepository;
import dev.tts.learning.spring_security.repository.UserRepository;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;

@Component
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    private final UserRepository userRepository;
    private final UserInfoRepository userInfoRepository;
    private final OAuth2UserService<OAuth2UserRequest, OAuth2User> defaultOAuth2UserService = new DefaultOAuth2UserService();

    public CustomOAuth2UserService(UserRepository userRepository, UserInfoRepository userInfoRepository) {
        this.userRepository = userRepository;
        this.userInfoRepository = userInfoRepository;
    }

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) {
        // Facebook, GitHub, v.v.
        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        OAuth2User oauth2User = defaultOAuth2UserService.loadUser(userRequest);
        String email = (String) oauth2User.getAttributes().get("email");
        checkAndSaveUser(email, registrationId);
        return oauth2User;
    }

    private void checkAndSaveUser(String email, String registrationId) {
        // Check if userEntity exists
        UserEntity userEntity = userRepository.findByUsername(email)
                .orElseGet(() -> {
                    // Lưu người dùng mới nếu chưa tồn tại
                    UserEntity newUserEntity = new UserEntity();
                    newUserEntity.setUsername(email);
                    newUserEntity.setRole(Role.user.name());
                    newUserEntity.setProvider(registrationId.toLowerCase());
                    return userRepository.save(newUserEntity);
                });

        UserInfoEntity userInfoEntity = userInfoRepository.findByUsername(email)
                .orElseGet(() -> {
                    // Lưu người dùng mới nếu chưa tồn tại
                    UserInfoEntity newUserInfoEntity = new UserInfoEntity();
                    newUserInfoEntity.setUsername(email);
                    newUserInfoEntity.setEmail(email);
                    return userInfoRepository.save(newUserInfoEntity);
                });
    }
}
