package org.jallen.tyrael.controller;

import java.util.List;

import org.jallen.tyrael.entity.Application;
import org.jallen.tyrael.services.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class ApplicationController {

  @Autowired
  private ApplicationService applicationService;

  @GetMapping("/applications")
  public List<Application> getAllApplications() {
    return applicationService.getAllApplications().stream()
      .filter(obj -> obj.getRepository() != null)
      .toList();
  }

  @GetMapping("/pages")
  public List<Application> getAllPages() {
    return applicationService.getAllApplications().stream()
      .filter(obj -> obj.getCategory().contains("Page"))
      .filter(obj -> obj.getRepository() != null)
      .toList();
  }

}
