package org.jallen.tyrael.services;

import java.util.List;

import org.jallen.tyrael.entity.Information;
import org.jallen.tyrael.repositories.InformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class InformationService {
  
  @Autowired
  private InformationRepository informationRepository;

  public List<Information> getAllInformations() {
    return informationRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
  }
}
