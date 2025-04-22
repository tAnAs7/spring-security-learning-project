package dev.tts.learning.spring_security.service;

import dev.tts.learning.spring_security.model.UserEntity;
import dev.tts.learning.spring_security.model.UserInfoEntity;
import dev.tts.learning.spring_security.repository.UserInfoRepository;
import dev.tts.learning.spring_security.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepo;
    private final UserInfoRepository userInfoRepo;

    public CustomUserDetailsService(UserRepository userRepo,
                                    UserInfoRepository userInfoRepo) {
        this.userRepo = userRepo;
        this.userInfoRepo = userInfoRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                List.of(new SimpleGrantedAuthority("ROLE_" + user.getRole()))
        );
    }

    public UserInfoEntity loadUserInfoByUsername(String username) throws UsernameNotFoundException {
        return userInfoRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User info not found"));
    }
}

