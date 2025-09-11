package com.qnadeel.springdemo.infrastructure.jwt;

import com.qnadeel.springdemo.core.securiry.JwtGenerator;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.UUID;

@Component
public class JwtTokenGenerator implements JwtGenerator {

    private final SecretKey secretKey;

    public JwtTokenGenerator() {
        String key = "2XwD8eRxMvT4n9VpLF9UyBG5cD7NlKmKqY6fO9qxMzU=";
        this.secretKey = Keys.hmacShaKeyFor
                (Decoders.BASE64.decode(key));

    }

    public String generateToken(UUID id, String emailOrUsername) {
        return Jwts
                .builder()
                .subject(id.toString())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis()
                        + 60 * 60 * 60 * 100))
                .signWith(secretKey)
                .issuer(emailOrUsername)
                .compact();
    }
}
