package dev.tts.learning.spring_security.controller;

import dev.tts.learning.spring_security.model.UserEntity;
import dev.tts.learning.spring_security.model.UserInfoEntity;
import dev.tts.learning.spring_security.model.dto.LoginRequest;
import dev.tts.learning.spring_security.model.dto.SignupRequest;
import dev.tts.learning.spring_security.security.JwtUtil;
import dev.tts.learning.spring_security.service.AuthService;
import dev.tts.learning.spring_security.service.CustomUserDetailsService;
import dev.tts.learning.spring_security.service.RefreshTokenService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/")
public class AuthController {
    @Autowired
    RefreshTokenService refreshTokenService;
    @Autowired
    AuthService authService;
    @Autowired
    CustomUserDetailsService userDetailsService;

    @PostMapping("/auth/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        try {
            Authentication auth = authService.authenticate(request.getUsername(), request.getPassword());

            String accessToken = JwtUtil.generateAccessToken(request.getUsername(), "user");
            String refreshToken = JwtUtil.generateRefreshToken(request.getUsername());
            refreshTokenService.saveOrUpdate(request.getUsername(), refreshToken, JwtUtil.REFRESH_TOKEN_EXPIRATION_TIME);

            return ResponseEntity.ok(Map.of(
                    "accessToken", accessToken,
                    "refreshToken", refreshToken
            ));
        } catch (AuthenticationException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
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

            String newAccessToken = JwtUtil.generateAccessToken(username, "user");

            return ResponseEntity.ok(Map.of(
                    "accessToken", newAccessToken
            ));

        } catch (JwtException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Expired or invalid refresh token");
        }
    }

    @PostMapping("/auth/signup")
    public ResponseEntity<?> signup(@RequestBody SignupRequest request) {
        boolean created = authService.register(request.getUsername(), request.getPassword());
        if (!created) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Username already exists");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
    }

    @PostMapping("/auth/logout")
    public ResponseEntity<?> logout(@RequestBody Map<String, String> payload) {
        String refreshToken = payload.get("refreshToken");

        try {
            Claims claims = JwtUtil.validateToken(refreshToken);
            String username = claims.getSubject();

            refreshTokenService.revokeToken(refreshToken);

            return ResponseEntity.ok("Logout successful");
        } catch (JwtException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid refresh token");
        }
    }

    @GetMapping("/auth/me")
    public ResponseEntity<?> getCurrentUser(@RequestHeader("Authorization") String authHeader) {
        try {
            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Missing or invalid Authorization header");
            }

            String accessToken = authHeader.substring(7); // Remove "Bearer "
            Claims claims = JwtUtil.validateToken(accessToken);
            String username = claims.getSubject();

            UserInfoEntity userInfo = userDetailsService.loadUserInfoByUsername(username);

            return ResponseEntity.ok(Map.of(
                    "info", userInfo
            ));
        } catch (ExpiredJwtException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Access token expired");
        } catch (JwtException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid access token");
        } catch (UsernameNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
}
