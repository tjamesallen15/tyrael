package org.jallen.tyrael.mapper;

import java.util.List;

import org.jallen.tyrael.base.BaseMapper;
import org.jallen.tyrael.entity.Skill;
import org.springframework.stereotype.Component;

@Component
public class SkillMapper implements BaseMapper<Skill> {

  @Override
  public List<Skill> getMapping(List<Skill> obj) {
    return obj.stream()
      .map(o -> {
      Skill skills = new Skill();
      skills.setId(o.getId());
      skills = getMapping(skills, o);

      return skills;
    }).toList();
  }

  @Override
  public Skill getMapping(Skill origin, Skill obj) {
    if (obj == null) return origin;

    origin.setExperience(obj.getExperience());
    origin.setDescription(obj.getDescription());
    origin.setName(obj.getName());
    origin.setType(obj.getType());

    return origin;
  }
  
}
