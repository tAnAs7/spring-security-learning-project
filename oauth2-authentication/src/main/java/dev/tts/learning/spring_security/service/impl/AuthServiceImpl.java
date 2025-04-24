package dev.tts.learning.spring_security.service.impl;

import dev.tts.learning.spring_security.model.UserEntity;
import dev.tts.learning.spring_security.model.UserInfoEntity;
import dev.tts.learning.spring_security.repository.UserInfoRepository;
import dev.tts.learning.spring_security.repository.UserRepository;
import dev.tts.learning.spring_security.service.AuthService;
import jakarta.transaction.Transactional;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;

    private final UserInfoRepository userInfoRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(AuthenticationManager authenticationManager,
                           UserRepository userRepository,
                           UserInfoRepository userInfoRepository,
                           PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.userInfoRepository = userInfoRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(String username, String password) throws AuthenticationException {
        return authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );
    }


    @Transactional
    @Override
    public boolean register(String username, String rawPassword) {
        if (userRepository.existsByUsername(username)) {
            return false;
        }

        String hashed = passwordEncoder.encode(rawPassword);
        UserEntity user = UserEntity.builder()
                .username(username)
                .password(hashed)
                .role("user") // default role
                .build();
        UserInfoEntity userInfo = UserInfoEntity.builder()
                .username(username)
                .build();
        userRepository.save(user);
        userInfoRepository.save(userInfo);
        return true;
    }

}
