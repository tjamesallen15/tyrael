package org.jallen.tyrael.mapper;

import java.util.List;

import org.jallen.tyrael.base.BaseMapper;
import org.jallen.tyrael.entity.About;
import org.springframework.stereotype.Component;

@Component
public class AboutMapper implements BaseMapper<About> {

  @Override
  public List<About> getMapping(List<About> obj) {
    return obj.stream()
      .map(o -> {
        About about = new About();
        about.setId(o.getId());
        about = getMapping(about, o);

        return about;
      }).toList();
  }

  @Override
  public About getMapping(About origin, About obj) {
    if (obj == null) return origin;

    origin.setDescription(obj.getDescription());
    
    return origin;
  }
  
}
