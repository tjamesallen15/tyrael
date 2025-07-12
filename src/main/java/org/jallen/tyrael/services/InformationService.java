package org.jallen.tyrael.services;

import java.util.List;
import java.util.Optional;

import org.jallen.tyrael.base.BaseService;
import org.jallen.tyrael.entity.Information;
import org.jallen.tyrael.mapper.InformationMapper;
import org.jallen.tyrael.repositories.InformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class InformationService implements BaseService<Information> {
  
  @Autowired
  private InformationRepository informationRepository;

  @Autowired
  private InformationMapper informationMapper;

  @Override
  public List<Information> findAll() {
    return informationRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
  }

  @Override
  public Optional<Information> findById(Long id) {
    return informationRepository.findById(id);
  }

  @Override
  public Information create(Information obj) {
    return informationRepository.save(obj);
  }

  @Override
  public Information update(Long id, Information obj) {
    Information information = informationRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Information not found with id: " + id));
    
    information = informationMapper.getMapping(information, obj);
    return informationRepository.save(information);
  }

  @Override
  public void delete(Long id) {
    if (informationRepository.existsById(id)) {
      informationRepository.deleteById(id);
    }
  }
}
