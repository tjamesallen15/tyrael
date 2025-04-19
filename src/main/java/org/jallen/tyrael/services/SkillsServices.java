package org.jallen.tyrael.services;

import java.util.List;

import org.jallen.tyrael.entity.Skills;
import org.jallen.tyrael.repositories.SkillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class SkillsServices {
  
  @Autowired
  private SkillsRepository skillsRepository;

  public List<Skills> getAllSkills() {
    return skillsRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
  }
}
