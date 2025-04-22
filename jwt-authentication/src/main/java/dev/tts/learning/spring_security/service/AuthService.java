package dev.tts.learning.spring_security.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public interface AuthService {
    Authentication authenticate(String username, String password) throws AuthenticationException;
    boolean register(String username, String rawPassword);
}
