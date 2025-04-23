package dev.tts.learning.spring_security.service.impl;

import dev.tts.learning.spring_security.model.RefreshToken;
import dev.tts.learning.spring_security.model.enums.TokenStatus;
import dev.tts.learning.spring_security.repository.RefreshTokenRepository;
import dev.tts.learning.spring_security.service.RefreshTokenService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RefreshTokenServiceImpl implements RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;

    public RefreshTokenServiceImpl(RefreshTokenRepository refreshTokenRepository) {
        this.refreshTokenRepository = refreshTokenRepository;
    }

    @Override
    public void saveOrUpdate(String username, String token, long expiryMillis) {
        refreshTokenRepository.findByUsername(username).ifPresentOrElse(existing -> {
            existing.setToken(token);
            existing.setExpiryDate(new Date(System.currentTimeMillis() + expiryMillis));
            refreshTokenRepository.save(existing);
        }, () -> {
            RefreshToken newToken = new RefreshToken(username, token, new Date(System.currentTimeMillis() + expiryMillis), TokenStatus.active.name());
            refreshTokenRepository.save(newToken);
        });
    }

    @Override
    public boolean exists(String username, String token) {
        return refreshTokenRepository.findByUsername(username)
                .map(stored -> stored.getToken().equals(token) && stored.getExpiryDate().after(new Date()))
                .orElse(false);
    }

    @Transactional
    public void revokeToken(String token) {
        RefreshToken refreshToken = refreshTokenRepository.findByToken(token)
                .orElseThrow(() -> new RuntimeException("Token not found"));

        refreshToken.setStatus(TokenStatus.revoked.name());
        refreshTokenRepository.save(refreshToken);
    }

    @Override
    public void deleteByUsername(String username) {
        refreshTokenRepository.deleteByUsername(username);
    }
}

