package org.jallen.tyrael.mapper;

import java.util.List;

import org.jallen.tyrael.base.BaseMapper;
import org.jallen.tyrael.entity.Application;
import org.springframework.stereotype.Component;

@Component
public class ApplicationMapper implements BaseMapper<Application> {

  @Override
  public List<Application> getMapping(List<Application> obj) {
    return obj.stream()
        .filter(o -> o.getRepository() != null)
        .map(o -> {
          Application application = new Application();
          application.setId(o.getId());
          application = getMapping(application, o);
          return application;
        })
        .toList();
  }

  @Override
  public Application getMapping(Application origin, Application obj) {
    if (obj == null) return origin;

    origin.setTitle(obj.getTitle());
    origin.setDescription(obj.getDescription());
    origin.setCategory(obj.getCategory());
    origin.setTech(obj.getTech());
    origin.setRepository(obj.getRepository());
    origin.setSite(obj.getSite());
    origin.setPriority(obj.getPriority());

    return origin;
  }
}
