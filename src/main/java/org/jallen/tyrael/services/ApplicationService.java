package org.jallen.tyrael.services;

import java.util.List;

import org.jallen.tyrael.entity.Application;
import org.jallen.tyrael.repositories.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService {

  @Autowired
  private ApplicationRepository applicationRepository;

  public List<Application> getAllApplications() {
    return applicationRepository.findAll(Sort.by(Sort.Direction.ASC, "priority"));
  }
}
