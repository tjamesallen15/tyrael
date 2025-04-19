package org.jallen.tyrael.controller;

import org.jallen.tyrael.entity.Information;
import org.jallen.tyrael.services.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class InformationController {
  
  @Autowired
  private InformationService informationService;

  @GetMapping("/informations")
  public List<Information> getAllInformations() {
    return informationService.getAllInformations();
  }

}
