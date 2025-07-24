package net.fiv.backend.config.jwtConfig;

import io.jsonwebtoken.security.Keys;
import net.fiv.backend.service.impl.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.*;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class JwtCore {

    private final String secret;

    private final int lifetime;

    private final SecretKey secretKey;

    public JwtCore(@Value("${backend.app.secret}") String secret, @Value("${backend.app.lifetime}") int lifetime) {
        this.secretKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        this.secret = secret;
        this.lifetime = lifetime;
    }

    public String generateToken(Authentication authentication) {
        UserDetailsImpl user = (UserDetailsImpl) authentication.getPrincipal();

        Map<String, Object> claims = new HashMap<>();

        claims.put("roles", user.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList()));


        return Jwts.builder()
                .setClaims(claims)
                .setSubject((user.getUsername()))
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + lifetime))
                .signWith(SignatureAlgorithm.HS256, secret.getBytes())
                .compact();
    }


    public Claims extractAllClaims(String token) {

        return Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public String getNameFromToken(String token) {
        return extractAllClaims(token).getSubject();
    }

    public List<SimpleGrantedAuthority> extractRoles(String token) {
        Claims claims = extractAllClaims(token);
        List<String> roles = claims.get("roles", List.class);


        return roles.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

}
