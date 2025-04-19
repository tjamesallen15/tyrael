package org.jallen.tyrael.services;

import java.util.List;

import org.jallen.tyrael.entity.About;
import org.jallen.tyrael.repositories.AboutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class AboutService {

  @Autowired
  private AboutRepository aboutRepository;

  public List<About> getAllAbouts() {
    return aboutRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
  }
}
