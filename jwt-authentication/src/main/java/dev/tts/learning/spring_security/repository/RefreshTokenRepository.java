package dev.tts.learning.spring_security.repository;

import dev.tts.learning.spring_security.model.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {

    Optional<RefreshToken> findByToken(String token);

    Optional<RefreshToken> findByUsername(String username);

    void deleteByToken(String token);

    void deleteByUsername(String username);
}