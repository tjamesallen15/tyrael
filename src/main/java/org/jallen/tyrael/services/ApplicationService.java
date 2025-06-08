package org.jallen.tyrael.services;

import java.util.List;

import org.jallen.tyrael.entity.Application;
import org.jallen.tyrael.repositories.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService implements BaseService<Application> {

  @Autowired
  private ApplicationRepository applicationRepository;

  @Override
  public List<Application> findAll() {
    return applicationRepository.findAll(Sort.by(Sort.Direction.ASC, "priority"));
  }

  @Override
  public Application findById(Long id) {
    return applicationRepository.findById(id).orElse(null);
  }

  @Override
  public Application create(Application obj) {
    return applicationRepository.save(obj);
  }

  @Override
  public void delete(Long id) {
    if (applicationRepository.existsById(id)) {
      applicationRepository.deleteById(id);
    }
  }

  @Override
  public Application update(Long id, Application obj) {
    Application app = applicationRepository.findById(id).orElse(null);
    if (app != null) {
      app.setTitle(obj.getTitle());
      app.setDescription(obj.getDescription());
      app.setCategory(obj.getCategory());
      app.setTech(obj.getTech());
      app.setRepository(obj.getRepository());
      app.setSite(obj.getSite());
      app.setPriority(obj.getPriority());
      return applicationRepository.save(app);
    }
    return app;
  }
}
