package org.jallen.tyrael.services;

import java.util.List;
import java.util.Optional;

import org.jallen.tyrael.base.BaseService;
import org.jallen.tyrael.entity.Work;
import org.jallen.tyrael.mapper.WorkMapper;
import org.jallen.tyrael.repositories.WorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class WorkService implements BaseService<Work>{
  
  @Autowired
  private WorkRepository workRepository;

  @Autowired
  private WorkMapper workMapper;

  @Override
  public List<Work> findAll() {
    return workRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
  }

  @Override
  public Optional<Work> findById(Long id) {
    return workRepository.findById(id);
  }

  @Override
  public Work create(Work obj) {
    return workRepository.save(obj);
  }

  @Override
  public void delete(Long id) {
    if (workRepository.existsById(id)) {
      workRepository.deleteById(id);
    }
  }

  @Override
  public Work update(Long id, Work obj) {
    Work work = workRepository.findById(id)
      .orElseThrow(() -> new RuntimeException("Work not found with id: " + id));
    work = workMapper.getMapping(work, obj);
    return workRepository.save(work);
  }
}
