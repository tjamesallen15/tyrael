package org.jallen.tyrael.services;

import java.util.List;
import java.util.Optional;

import org.jallen.tyrael.base.BaseService;
import org.jallen.tyrael.entity.Skill;
import org.jallen.tyrael.mapper.SkillMapper;
import org.jallen.tyrael.repositories.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class SkillService implements BaseService<Skill> {
  
  @Autowired
  private SkillRepository skillRepository;

  @Autowired
  private SkillMapper skillMapper;

  @Override
  public List<Skill> findAll() {
    return skillRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
  }

  @Override
  public Optional<Skill> findById(Long id) {
    return skillRepository.findById(id);
  }

  @Override
  public Skill create(Skill obj) {
    return skillRepository.save(obj);
  }

  @Override
  public Skill update(Long id, Skill obj) {
    Skill skills = skillRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Skills not found with id: " + id));

    skills = skillMapper.getMapping(skills, obj);
    return skillRepository.save(skills);
  }

  @Override
  public void delete(Long id) {
    if (skillRepository.existsById(id)) {
      skillRepository.deleteById(id);
    }
  }
}
