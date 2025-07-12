package org.jallen.tyrael.controller;

import org.jallen.tyrael.base.BaseController;
import org.jallen.tyrael.entity.Information;
import org.jallen.tyrael.mapper.InformationMapper;
import org.jallen.tyrael.services.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
public class InformationController implements BaseController<Information> {
  
  @Autowired
  private InformationService informationService;

  @Autowired
  private InformationMapper informationMapper;

  @GetMapping("/information")
  @Override
  public ResponseEntity<List<Information>> findAll() {
    List<Information> informations = informationMapper.getMapping(informationService.findAll());
    return ResponseEntity.ok(informations);
  }

  @GetMapping("information/{id}")
  @Override
  public ResponseEntity<Information> findById(Long id) {
    Optional<Information> information = informationService.findById(id);
    return information.map(o -> ResponseEntity.ok(o))
      .orElse(ResponseEntity.notFound().build());
  }

  @Override
  public ResponseEntity<Information> create(Information obj) {
    Information information = informationService.create(obj);
    return ResponseEntity.status(201).body(information);
  }

  @Override
  public ResponseEntity<Information> update(Long id, Information obj) {
    Information information = informationService.update(id, obj);
    return ResponseEntity.ok(information);
  }

  @Override
  public ResponseEntity<?> delete(Long id) {
    informationService.delete(id);
    return ResponseEntity.noContent().build();
  }

}
