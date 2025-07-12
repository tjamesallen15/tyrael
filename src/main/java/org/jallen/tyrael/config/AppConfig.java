package org.jallen.tyrael.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "app")
@Component
@Data
public class AppConfig {
  private String jwtSecret;
  private long jwtExpiration;
  private Database database = new Database();
  
  @Data
  public static class Database {
    private String url;
    private String username;
    private String password;
  }
}