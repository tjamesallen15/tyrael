package org.jallen.tyrael.controller;

import org.jallen.tyrael.services.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TyraelController {

  @Autowired
  private JwtService jwtService;

  @Value("${app.admin.username}")
  private String adminUsername;

  @Value("${app.admin.password}")
  private String adminPassword;

  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestParam("username") String username, @RequestParam("password") String password) {
    if (username == null || password == null) {
      return ResponseEntity.badRequest().body(Map.of("error", "Username and password required"));
    }

    if (username.equals(adminUsername) && password.equals(adminPassword)) {
      String token = jwtService.generateToken(username);
      return ResponseEntity.ok(Map.of("token", token));
    }

    return ResponseEntity.status(401).body(Map.of("error", "Invalid credentials"));
  }
}
