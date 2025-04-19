package org.jallen.tyrael.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.jallen.tyrael.entity.Experience;
import org.jallen.tyrael.mapper.ExperienceMapper;
import org.jallen.tyrael.services.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExperienceController {

  @Autowired
  private ExperienceService experienceService;

  @GetMapping("/experiences")
  public List<Experience> getAllExperiences() {
    return experienceService.getAllExperiences().stream()
      .peek(exp -> 
        exp.setTotal(getExperienceMapper().transformTotal(exp.getDuration(), exp.getTotal()))
      )
      .collect(Collectors.toList());
  }

  private ExperienceMapper getExperienceMapper() {
    return new ExperienceMapper();
  }
}
