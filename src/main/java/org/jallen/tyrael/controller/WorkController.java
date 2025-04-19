package org.jallen.tyrael.controller;

import java.util.List;

import org.jallen.tyrael.entity.Work;
import org.jallen.tyrael.services.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkController {
  
  @Autowired
  private WorkService workService;

  @GetMapping("/works")
  public List<Work> getAllWorks() {
    return workService.getAllWorks();
  }

}
