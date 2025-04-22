package dev.tts.learning.spring_security.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;

public class JwtUtil {
    private static final String SECRET_KEY = "your-secret-key-your-secret-key-your-secret-key";
    public static final long ACCESS_TOKEN_EXPIRATION_TIME = 15 * 60 * 1000L; // 15 minutes
    public static final long REFRESH_TOKEN_EXPIRATION_TIME = 7 * 24 * 60 * 60 * 1000L; // 7 days

    private static final Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

    public static String generateAccessToken(String username, String role) {
        JwtBuilder builder = Jwts.builder();
        return builder
                .subject(username)
                .claim("role", role)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + ACCESS_TOKEN_EXPIRATION_TIME))
                .signWith(key) // ✅ dùng Signature enum mới
                .compact();
    }

    public static String generateRefreshToken(String username) {
        JwtBuilder builder = Jwts.builder();
        return builder
                .subject(username)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + REFRESH_TOKEN_EXPIRATION_TIME)) // 7 ngày
                .signWith(key)
                .compact();
    }

    public static Claims validateToken(String token) {
        JwtParser parser = Jwts.parser()
                .verifyWith((SecretKey) key) // ✅ không còn dùng setSigningKey
                .build();

        Jws<Claims> jws = parser.parseSignedClaims(token);
        return jws.getPayload();
    }
}
