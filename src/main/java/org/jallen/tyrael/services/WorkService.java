package org.jallen.tyrael.services;

import java.util.List;

import org.jallen.tyrael.entity.Work;
import org.jallen.tyrael.repositories.WorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class WorkService {
  
  @Autowired
  private WorkRepository workRepository;

  public List<Work> getAllWorks() {
    return workRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
  }
}
