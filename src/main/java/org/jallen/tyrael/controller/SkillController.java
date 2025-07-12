package org.jallen.tyrael.controller;

import java.util.List;
import java.util.Optional;

import org.jallen.tyrael.base.BaseController;
import org.jallen.tyrael.entity.Skill;
import org.jallen.tyrael.exception.EntityNotFoundException;
import org.jallen.tyrael.mapper.SkillMapper;
import org.jallen.tyrael.services.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SkillController implements BaseController<Skill> {
  
  @Autowired
  private SkillService skillService;

  @Autowired
  private SkillMapper skillMapper;

  @GetMapping("/skill")
  @Override
  public ResponseEntity<List<Skill>> findAll() {
    List<Skill> skills = skillMapper.getMapping(skillService.findAll());
    return ResponseEntity.ok(skills);
  }

  @GetMapping("/skill/{id}")
  @Override
  public ResponseEntity<Skill> findById(Long id) {
    Skill skill = skillService.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Skill not found with id: " + id));
    return ResponseEntity.ok(skill);
  }

  @PostMapping("/skill")
  @Override
  public ResponseEntity<Skill> create(Skill obj) {
    Skill skills = skillService.create(obj);
    return ResponseEntity.status(201).body(skills);
  }

  @PutMapping("/skill/{id}")
  @Override
  public ResponseEntity<Skill> update(Long id, Skill obj) {
    Skill skills = skillService.update(id, obj);
    return ResponseEntity.ok(skills);
  }

  @DeleteMapping("/skill/{id}")
  @Override
  public ResponseEntity<?> delete(Long id) {
    if (skillService.findById(id).isEmpty()) {
      throw new EntityNotFoundException("Skill not found with id: " + id);
    }
    skillService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
