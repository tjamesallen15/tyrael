package org.jallen.tyrael.services;

import java.util.List;
import java.util.Optional;

import org.jallen.tyrael.base.BaseService;
import org.jallen.tyrael.entity.Skill;
import org.jallen.tyrael.mapper.SkillMapper;
import org.jallen.tyrael.repositories.SkillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class SkillServices implements BaseService<Skill> {
  
  @Autowired
  private SkillsRepository skillsRepository;

  @Autowired
  private SkillMapper skillsMapper;

  @Override
  public List<Skill> findAll() {
    return skillsRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
  }

  @Override
  public Optional<Skill> findById(Long id) {
    return skillsRepository.findById(id);
  }

  @Override
  public Skill create(Skill obj) {
    return skillsRepository.save(obj);
  }

  @Override
  public Skill update(Long id, Skill obj) {
    Skill skills = skillsRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Skills not found with id: " + id));

    skills = skillsMapper.getMapping(skills, obj);
    return skillsRepository.save(skills);
  }

  @Override
  public void delete(Long id) {
    if (skillsRepository.existsById(id)) {
      skillsRepository.deleteById(id);
    }
  }
}
