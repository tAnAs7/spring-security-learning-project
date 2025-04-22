package dev.tts.learning.spring_security.controller;

import dev.tts.learning.spring_security.model.dto.LoginRequest;
import dev.tts.learning.spring_security.security.JwtUtil;
import dev.tts.learning.spring_security.service.AuthService;
import dev.tts.learning.spring_security.service.RefreshTokenService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/")
public class AuthController {
    @Autowired
    RefreshTokenService refreshTokenService;
    @Autowired
    AuthService authService;

    @PostMapping("/auth/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        if (authService.isValidUser(request)) {
            String accessToken = JwtUtil.generateAccessToken(request.getUsername(), "USER");
            String refreshToken = JwtUtil.generateRefreshToken(request.getUsername());

            refreshTokenService.saveOrUpdate(request.getUsername(), refreshToken, JwtUtil.REFRESH_TOKEN_EXPIRATION_TIME);

            return ResponseEntity.ok(Map.of(
                    "accessToken", accessToken,
                    "refreshToken", refreshToken
            ));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }

    @PostMapping("/auth/refresh")
    public ResponseEntity<?> refresh(@RequestBody Map<String, String> payload) {
        String refreshToken = payload.get("refreshToken");

        try {
            Claims claims = JwtUtil.validateToken(refreshToken);
            String username = claims.getSubject();

            if (!refreshTokenService.exists(username, refreshToken)) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid refresh token");
            }

            String newAccessToken = JwtUtil.generateAccessToken(username, "USER");

            return ResponseEntity.ok(Map.of(
                    "accessToken", newAccessToken
            ));

        } catch (JwtException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Expired or invalid refresh token");
        }
    }
}
