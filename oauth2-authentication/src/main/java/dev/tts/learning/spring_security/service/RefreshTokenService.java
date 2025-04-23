package dev.tts.learning.spring_security.service;

public interface RefreshTokenService {
    void saveOrUpdate(String username, String token, long expiryMillis);

    boolean exists(String username, String token);

    void revokeToken(String token);

    void deleteByUsername(String username);
}