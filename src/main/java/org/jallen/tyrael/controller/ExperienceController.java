package org.jallen.tyrael.controller;

import java.util.List;
import java.util.Optional;

import org.jallen.tyrael.base.BaseController;
import org.jallen.tyrael.entity.Experience;
import org.jallen.tyrael.exception.EntityNotFoundException;
import org.jallen.tyrael.mapper.ExperienceMapper;
import org.jallen.tyrael.services.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExperienceController implements BaseController<Experience> {

  @Autowired
  private ExperienceService experienceService;

  @Autowired
  private ExperienceMapper experienceMapper;


  @GetMapping("/experience")
  @Override
  public ResponseEntity<List<Experience>> findAll() {
    List<Experience> experiences = experienceMapper.getMapping(experienceService.findAll());
    return ResponseEntity.ok(experiences);
  }

  @GetMapping("/experience/{id}")
  @Override
  public ResponseEntity<Experience> findById(Long id) {
    Experience experience = experienceService.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Experience not found with id: " + id));
    return ResponseEntity.ok(experience);
  }

  @PostMapping("/experience")
  @Override
  public ResponseEntity<Experience> create(Experience obj) {
    Experience experience = experienceService.create(obj);
    return ResponseEntity.status(201).body(experience);
  }

  @Override
  public ResponseEntity<Experience> update(Long id, Experience obj) {
    Experience experience = experienceService.update(id, obj);
    return ResponseEntity.ok(experience);
  }

  @Override
  public ResponseEntity<?> delete(Long id) {
    if (experienceService.findById(id).isEmpty()) {
      throw new EntityNotFoundException("Experience not found with id: " + id);
    }
    experienceService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
