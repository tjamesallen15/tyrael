package org.jallen.tyrael.services;

import java.util.List;

import org.jallen.tyrael.entity.Experience;
import org.jallen.tyrael.repositories.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ExperienceService {
  
  @Autowired
  private ExperienceRepository experienceRepository;

  public List<Experience> getAllExperiences() {
    return experienceRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
  }
}
