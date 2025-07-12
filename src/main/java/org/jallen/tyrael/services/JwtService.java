package org.jallen.tyrael.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtService {
    
  private final SecretKey key = Keys.hmacShaKeyFor("mySecretKeyForJWTTokenGenerationThatIsLongEnough".getBytes());
  
  public String generateToken(String username) {
    return Jwts.builder()
      .subject(username)
      .issuedAt(new Date())
      .expiration(new Date(System.currentTimeMillis() + 86400000)) // 24 hours
      .signWith(key)
      .compact();
  }
}