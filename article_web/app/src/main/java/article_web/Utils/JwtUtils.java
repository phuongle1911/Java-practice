package article_web.Utils;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class JwtUtils {
  private String jwtSecret;
  private SecretKey key;

  public JwtUtils() {
    init();
  }

  private void init() {
    try {
      this.jwtSecret = System.getenv("JWT_SECRET");
      this.key = Keys.hmacShaKeyFor(jwtSecret.getBytes(StandardCharsets.UTF_8));
    } catch (Exception e) {
      System.out.println("Failed to create jwt keys!" + e);
    }
  }
    

  public String generateJwt(int id) {
    try {
      return Jwts.builder()
        .subject(Integer.toString(id))
        .expiration(new Date(new Date().getTime() + 30*60*1000))
        .signWith(key)
        .compact();
    } catch (Exception e) {
      System.out.println("failed to generate jwt!" + e);
      return null;
    }
  }

  public int getIdFromJwt(String token) {
    try {
      String id = Jwts.parser()
            .verifyWith(key)
            .build()
            .parseSignedClaims(token)
            .getPayload().getSubject();
      return Integer.parseInt(id);
    } catch (Exception e) {
      System.out.println("failed to identify user id!" + e);
      return 0;
    }
  }

    public boolean validateJwt(String token, int id) {
      try { 
        int tokenUserId = getIdFromJwt(token);
        boolean isExpired = Jwts.parser()
                            .verifyWith(key)
                            .build()
                            .parseSignedClaims(token)
                            .getPayload()
                            .getExpiration().before(new Date());

        if (tokenUserId == id && !isExpired) {
          return true;
        }
        return false;
      } catch (Exception e) {
        System.out.println("Fail to validate token!" + e);
        return false;
      }
    }
  }

  

