package dev.tts.learning.spring_security.repository;

import dev.tts.learning.spring_security.model.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserInfoRepository extends JpaRepository<UserInfoEntity, Long> {
    Optional<UserInfoEntity> findByUsername(String username);

    boolean existsByUsername(String username);
}