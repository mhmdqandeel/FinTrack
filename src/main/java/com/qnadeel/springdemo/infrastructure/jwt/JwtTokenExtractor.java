package com.qnadeel.springdemo.infrastructure.jwt;

import com.qnadeel.springdemo.core.securiry.JwtExtractor;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Optional;
import java.util.function.Function;

@Component
public class JwtTokenExtractor implements JwtExtractor {

    private final SecretKey secretKey;

    public JwtTokenExtractor() {
        String key = "2XwD8eRxMvT4n9VpLF9UyBG5cD7NlKmKqY6fO9qxMzU=";
        this.secretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(key));
    }

    @Override
    public Optional<String> extractUsername(String token) {
        try {
            return Optional.ofNullable(extractClaim(token, claims -> claims.get("username", String.class)));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public boolean validateToken(String token, UserDetails userDetails) {
        return extractUsername(token)
                .map(username -> username.equals(userDetails.getUsername()) && !isTokenExpired(token))
                .orElse(false);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private <T> T extractClaim(String token, Function<Claims, T> resolver) {
        Claims claims = Jwts.parser().verifyWith(secretKey)
                .build().parseSignedClaims(token).getPayload();
        return resolver.apply(claims);
    }
}
