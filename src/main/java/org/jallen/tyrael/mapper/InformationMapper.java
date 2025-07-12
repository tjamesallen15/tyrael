package org.jallen.tyrael.mapper;

import java.util.List;

import org.jallen.tyrael.base.BaseMapper;
import org.jallen.tyrael.entity.Information;
import org.springframework.stereotype.Component;

@Component
public class InformationMapper implements BaseMapper<Information> {

  @Override
  public List<Information> getMapping(List<Information> obj) {
    return obj.stream()
      .map(o -> {
      Information information = new Information();
      information.setId(o.getId());
      information = getMapping(information, o);

      return information;
    }).toList();
  }

  @Override
  public Information getMapping(Information origin, Information obj) {
    if (obj == null) return origin;

    origin.setName(obj.getName());
    origin.setValue(obj.getValue());

    return origin;
  }
  
}
