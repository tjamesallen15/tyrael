package org.jallen.tyrael.services;

import java.util.List;
import java.util.Optional;

import org.jallen.tyrael.base.BaseService;
import org.jallen.tyrael.entity.Experience;
import org.jallen.tyrael.mapper.ExperienceMapper;
import org.jallen.tyrael.repositories.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ExperienceService implements BaseService<Experience> {
  
  @Autowired
  private ExperienceRepository experienceRepository;

  @Autowired
  private ExperienceMapper experienceMapper;

  @Override
  public List<Experience> findAll() {
    return experienceRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
  }

  @Override
  public Optional<Experience> findById(Long id) {
    return experienceRepository.findById(id);
  }

  @Override
  public Experience create(Experience obj) {
    return experienceRepository.save(obj);
  }

  @Override
  public Experience update(Long id, Experience obj) {
    Experience exp = experienceRepository.findById(id)
      .orElseThrow(() -> new RuntimeException("Experience not found with id: " + id));
    exp = experienceMapper.getMapping(exp, obj);
    return experienceRepository.save(exp);
  }

  @Override
  public void delete(Long id) {
    if (experienceRepository.existsById(id)) {
      experienceRepository.deleteById(id);
    }
  }
}
