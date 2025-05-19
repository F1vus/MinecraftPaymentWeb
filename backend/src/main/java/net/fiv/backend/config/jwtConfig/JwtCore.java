package net.fiv.backend.config.jwtConfig;

import io.jsonwebtoken.security.Keys;
import net.fiv.backend.service.impl.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.*;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtCore {

    @Value("${backend.app.secret}")
    private String secret;

    @Value("${backend.app.lifetime}")
    private int lifetime;

    public String generateToken(Authentication authentication) {
        UserDetailsImpl user = (UserDetailsImpl) authentication.getPrincipal();
        return Jwts.builder().setSubject((user.getUsername())).setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + lifetime))
                .signWith(SignatureAlgorithm.HS256, secret.getBytes())
                .compact();
    }


    public String getNameFromToken(String token) {
        SecretKey secretKey = Keys.hmacShaKeyFor(secret.getBytes());

        return Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

}
