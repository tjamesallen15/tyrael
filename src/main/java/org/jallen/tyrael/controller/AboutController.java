package org.jallen.tyrael.controller;

import java.util.List;
import java.util.Optional;

import org.jallen.tyrael.base.BaseController;
import org.jallen.tyrael.entity.About;
import org.jallen.tyrael.mapper.AboutMapper;
import org.jallen.tyrael.services.AboutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AboutController implements BaseController<About> {

  @Autowired
  AboutService aboutService;

  @Autowired
  AboutMapper aboutMapper;

  @GetMapping("/about")
  @Override
  public ResponseEntity<List<About>> findAll() {
    List<About> abouts = aboutMapper.getMapping(aboutService.findAll());
    return ResponseEntity.ok(abouts);
  }

  @GetMapping("/about/{id}")
  @Override
  public ResponseEntity<About> findById(Long id) {
    Optional<About> about = aboutService.findById(id);
    return about.map(o -> ResponseEntity.ok(o))
      .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping("/about")
  @Override
  public ResponseEntity<About> create(About obj) {
    About about = aboutService.create(obj);
    return ResponseEntity.status(201).body(about);
  }

  @PutMapping("/about/{id}")
  @Override
  public ResponseEntity<About> update(Long id, About obj) {
    About about = aboutService.update(id, obj);
    return ResponseEntity.ok(about);
  }

  @Override
  public ResponseEntity<?> delete(Long id) {
    aboutService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
