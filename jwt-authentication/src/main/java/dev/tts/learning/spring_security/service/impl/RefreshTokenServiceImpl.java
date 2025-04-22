package dev.tts.learning.spring_security.service.impl;

import dev.tts.learning.spring_security.model.RefreshToken;
import dev.tts.learning.spring_security.repository.RefreshTokenRepository;
import dev.tts.learning.spring_security.service.RefreshTokenService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RefreshTokenServiceImpl implements RefreshTokenService {

    private final RefreshTokenRepository tokenRepository;

    public RefreshTokenServiceImpl(RefreshTokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    @Override
    public void saveOrUpdate(String username, String token, long expiryMillis) {
        tokenRepository.findByUsername(username).ifPresentOrElse(existing -> {
            existing.setToken(token);
            existing.setExpiryDate(new Date(System.currentTimeMillis() + expiryMillis));
            tokenRepository.save(existing);
        }, () -> {
            RefreshToken newToken = new RefreshToken(username, token, new Date(System.currentTimeMillis() + expiryMillis));
            tokenRepository.save(newToken);
        });
    }

    @Override
    public boolean exists(String username, String token) {
        return tokenRepository.findByUsername(username)
                .map(stored -> stored.getToken().equals(token) && stored.getExpiryDate().after(new Date()))
                .orElse(false);
    }

    @Override
    public void deleteByToken(String token) {
        tokenRepository.deleteByToken(token);
    }

    @Override
    public void deleteByUsername(String username) {
        tokenRepository.deleteByUsername(username);
    }
}

