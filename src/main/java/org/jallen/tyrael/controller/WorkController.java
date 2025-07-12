package org.jallen.tyrael.controller;

import java.util.List;
import java.util.Optional;

import org.jallen.tyrael.base.BaseController;
import org.jallen.tyrael.entity.Work;
import org.jallen.tyrael.exception.EntityNotFoundException;
import org.jallen.tyrael.mapper.WorkMapper;
import org.jallen.tyrael.services.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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

  @Autowired
  private WorkMapper workMapper;

  @GetMapping("/work")
  @Override
  public ResponseEntity<List<Work>> findAll() {
    List<Work> works = workMapper.getMapping(workService.findAll());
    return ResponseEntity.ok(works);
  }

  @GetMapping("/work/{id}")
  @Override
  public ResponseEntity<Work> findById(@PathVariable("id") Long id) {
    Work work = workService.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Work not found with id: " + id));
    return ResponseEntity.ok(work);
  }

  @PostMapping("/work")
  @Override
  public ResponseEntity<Work> create(@RequestBody Work obj) {
    Work work = workService.create(obj);
    return ResponseEntity.status(201).body(work);
  }

  @PutMapping("/work/{id}")
  @Override
  public ResponseEntity<Work> update(@PathVariable("id") Long id, @RequestBody Work obj) {
    Work work = workService.update(id, obj);
    return ResponseEntity.ok(work);
  }

  @DeleteMapping("/work/{id}")
  public ResponseEntity<?> delete(@PathVariable("id") Long id) {
    if (workService.findById(id).isEmpty()) {
      throw new EntityNotFoundException("Work not found with id: " + id);
    }
    workService.delete(id);
    return ResponseEntity.noContent().build();
  }

}
