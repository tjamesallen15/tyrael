package org.jallen.tyrael.controller;

import java.util.List;

import org.jallen.tyrael.entity.About;
import org.jallen.tyrael.services.AboutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AboutController {

  @Autowired
  AboutService aboutService;

  @GetMapping("/abouts")
  public List<About> getAllAbouts() {
    return aboutService.getAllAbouts().stream()
      .filter(obj -> obj.getDescription() != null)
      .toList();
  }
}
