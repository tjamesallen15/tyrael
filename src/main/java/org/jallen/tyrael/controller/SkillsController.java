package org.jallen.tyrael.controller;

import java.util.List;

import org.jallen.tyrael.entity.Skills;
import org.jallen.tyrael.services.SkillsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SkillsController {
  
  @Autowired
  private SkillsServices skillsServices;

  @GetMapping("/skills")
  public List<Skills> getAllSkills() {
    return skillsServices.getAllSkills();
  }
}
