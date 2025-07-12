package org.jallen.tyrael.services;

import java.util.List;
import java.util.Optional;

import org.jallen.tyrael.base.BaseService;
import org.jallen.tyrael.entity.Application;
import org.jallen.tyrael.mapper.ApplicationMapper;
import org.jallen.tyrael.repositories.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService implements BaseService<Application> {

  @Autowired
  private ApplicationRepository applicationRepository;

  @Autowired
  private ApplicationMapper applicationMapper;

  @Override
  public List<Application> findAll() {
    return applicationRepository.findAll(Sort.by(Sort.Direction.ASC, "priority"));
  }

  @Override
  public Optional<Application> findById(Long id) {
    return applicationRepository.findById(id);
  }

  @Override
  public Application create(Application obj) {
    return applicationRepository.save(obj);
  }

  @Override
  public Application update(Long id, Application obj) {
    Application app = applicationRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Application not found with id: " + id));
    app = applicationMapper.getMapping(app, obj);
    return applicationRepository.save(app);
  }

  @Override
  public void delete(Long id) {
    if (applicationRepository.existsById(id)) {
      applicationRepository.deleteById(id);
    }
  }
}
