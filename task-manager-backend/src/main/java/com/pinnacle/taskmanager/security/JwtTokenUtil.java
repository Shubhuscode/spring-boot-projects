package com.pinnacle.taskmanager.security;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenUtil {

    private static final String SECRET_KEY = "your-secret-key";  // Keep this safe

    public String generateToken(String username) {
        return Jwts.builder()
            .setSubject(username)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + 3600000))  // 1 hour
            .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
            .compact();
    }

    public boolean validateToken(String token, String username) {
        String extractedUsername = extractUsername(token);
        return (username.equals(extractedUsername) && !isTokenExpired(token));
    }

    public String extractUsername(String token) {
        return Jwts.parserBuilder()  // Use parserBuilder() instead of parser()
            .setSigningKey(SECRET_KEY)
            .build()  // Build the parser
            .parseClaimsJws(token)
            .getBody()
            .getSubject();
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return Jwts.parserBuilder()  // Use parserBuilder() instead of parser()
            .setSigningKey(SECRET_KEY)
            .build()  // Build the parser
            .parseClaimsJws(token)
            .getBody()
            .getExpiration();
    }
}
