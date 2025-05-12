package org.jallen.tyrael.controller;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.jallen.tyrael.entity.Application;
import org.jallen.tyrael.services.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class ApplicationController implements BaseController<Application> {

  @Autowired
  private ApplicationService applicationService;

  @GetMapping("/applications")
  @Override
  public List<Application> findAll() {
    return applicationService.findAll().stream()
        .filter(obj -> obj.getRepository() != null)
        .toList();
  }

  @GetMapping("/applications/")
  public List<Application> findAllIndex() {
    return applicationService.findAll().stream()
        .filter(obj -> obj.getRepository() != null)
        .map(obj -> {
          Application application = new Application();
          application.setId(obj.getId());
          application.setTitle(obj.getTitle());
          return application;
        })
        .toList();
  }

  @GetMapping("/applications/{id}")
  @Override
  public Application findById(@PathVariable("id") Long id) {
    return applicationService.findById(id);
  }

  @PostMapping("/applications/")
  @Override
  public Application create(@RequestBody Application obj) {
    return applicationService.create(obj);
  }

  @PutMapping("/applications/{id}")
  @Override
  public Application update(@PathVariable("id") Long id, @RequestBody Application obj) {
    return applicationService.update(id, obj);
  }

  @GetMapping("/pages")
  public List<Application> getAllPages() {
    return applicationService.findAll().stream()
        .filter(obj -> obj.getCategory().contains("Page"))
        .filter(obj -> obj.getRepository() != null)
        .toList();
  }

}
