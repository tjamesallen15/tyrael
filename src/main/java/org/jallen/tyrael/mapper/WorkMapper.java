package org.jallen.tyrael.mapper;

import java.util.List;

import org.jallen.tyrael.base.BaseMapper;
import org.jallen.tyrael.entity.Work;
import org.springframework.stereotype.Component;

@Component
public class WorkMapper implements BaseMapper<Work> {

  @Override
  public List<Work> getMapping(List<Work> obj) {
    return obj.stream().map(o -> {
      Work work = new Work();
      work.setId(o.getId());
      work = getMapping(work, o);
      return work;
    }).toList();
  }

  @Override
  public Work getMapping(Work origin, Work obj) {
    if (obj == null) return origin;

    origin.setName(obj.getName());
    origin.setSub(obj.getSub());
    origin.setTechnology(obj.getTechnology());
    origin.setCompany(obj.getCompany());
    origin.setDescription(obj.getDescription());

    return origin;
  }
  
}
