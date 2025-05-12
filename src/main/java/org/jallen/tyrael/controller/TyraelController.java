package org.jallen.tyrael.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TyraelController {

  @GetMapping("/login")
  public String validateLogin(@RequestParam("username") String username, @RequestParam("password") String password) {
    boolean validate = false;
    if (username == null || password == null)
      validate = false;

    validate = username.equals("jallen") &&
        password.equals("adminroot");
    return Boolean.toString(validate);
  }
}
