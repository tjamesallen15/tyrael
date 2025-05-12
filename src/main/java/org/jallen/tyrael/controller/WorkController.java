package org.jallen.tyrael.controller;

import java.util.List;

import org.jallen.tyrael.entity.Work;
import org.jallen.tyrael.services.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkController implements BaseController<Work> {

  @Autowired
  private WorkService workService;

  @GetMapping("/works")
  @Override
  public List<Work> findAll() {
    return workService.findAll();
  }

  @GetMapping("/works/")
  public List<Work> findAllIndex() {
    return workService.findAll().stream()
        .map(obj -> {
          Work work = new Work();
          work.setId(obj.getId());
          work.setName(obj.getName());
          return work;
        }).toList();
  }

  @GetMapping("/works/{id}")
  @Override
  public Work findById(@PathVariable("id") Long id) {
    return workService.findById(id);
  }

  @PostMapping("/works/")
  @Override
  public Work create(Work obj) {
    return workService.create(obj);
  }

  @PutMapping("/works/{id}")
  @Override
  public Work update(@PathVariable("id") Long id, @RequestBody Work obj) {
    return workService.update(id, obj);
  }

}
