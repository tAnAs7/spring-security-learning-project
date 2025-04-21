package dev.tts.learning.spring_security.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;

public class JwtUtil {
    private static final String SECRET_KEY = "your-secret-key-your-secret-key-your-secret-key";
    private static final long EXPIRATION_TIME = 86400000L; // 1 day

    private static final Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

    public static String generateToken(String username, String role) {
        JwtBuilder builder = Jwts.builder();
        return builder
                .subject(username)
                .claim("role", role)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key) // ✅ dùng Signature enum mới
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
