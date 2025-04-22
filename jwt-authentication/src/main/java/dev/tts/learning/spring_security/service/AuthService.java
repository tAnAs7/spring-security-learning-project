package dev.tts.learning.spring_security.service;

import dev.tts.learning.spring_security.model.dto.LoginRequest;

public interface AuthService {
    boolean isValidUser(LoginRequest request);
}