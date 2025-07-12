package org.jallen.tyrael.services;

import java.util.List;
import java.util.Optional;

import org.jallen.tyrael.base.BaseService;
import org.jallen.tyrael.entity.About;
import org.jallen.tyrael.mapper.AboutMapper;
import org.jallen.tyrael.repositories.AboutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class AboutService implements BaseService<About> {

  @Autowired
  private AboutRepository aboutRepository;

  @Autowired
  private AboutMapper aboutMapper;

  @Override
  public List<About> findAll() {
    return aboutRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
  }

  @Override
  public Optional<About> findById(Long id) {
    return aboutRepository.findById(id);
  }

  @Override
  public About create(About obj) {
    return aboutRepository.save(obj);
  }

  @Override
  public About update(Long id, About obj) {
    About about = aboutRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("About not found with id: " + id));

    about = aboutMapper.getMapping(about, obj);
    return aboutRepository.save(about);
  }

  @Override
  public void delete(Long id) {
    if (aboutRepository.existsById(id)) {
      aboutRepository.deleteById(id);
    }
  }
}
