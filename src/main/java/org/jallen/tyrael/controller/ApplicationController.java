package org.jallen.tyrael.controller;

import java.util.List;
import java.util.Optional;

import org.jallen.tyrael.base.BaseController;
import org.jallen.tyrael.entity.Application;
import org.jallen.tyrael.mapper.ApplicationMapper;
import org.jallen.tyrael.services.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class ApplicationController implements BaseController<Application> {

  @Autowired
  private ApplicationService applicationService;

  @Autowired
  private ApplicationMapper applicationMapper;

  @GetMapping("/application")
  @Override
  public ResponseEntity<List<Application>> findAll() {
    List<Application> applications = applicationMapper.getMapping(applicationService.findAll());
    return ResponseEntity.ok(applications);
  }

  @GetMapping("/application/{id}")
  @Override
  public ResponseEntity<Application> findById(@PathVariable("id") Long id) {
    Optional<Application> application = applicationService.findById(id);
    return application.map(o -> ResponseEntity.ok(o))
      .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping("/application")
  @Override
  public ResponseEntity<Application> create(@RequestBody Application obj) {
    Application application = applicationService.create(obj);
    return ResponseEntity.status(201).body(application);
  }

  @PutMapping("/application/{id}")
  @Override
  public ResponseEntity<Application> update(@PathVariable("id") Long id, @RequestBody Application obj) {
    Application application = applicationService.update(id, obj);
    return ResponseEntity.ok(application);
  }

  @DeleteMapping("/application/{id}")
  public ResponseEntity<?> delete(@PathVariable("id") Long id) {
    applicationService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
