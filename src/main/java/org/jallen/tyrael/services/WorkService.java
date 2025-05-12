package org.jallen.tyrael.services;

import java.util.List;

import org.jallen.tyrael.entity.Work;
import org.jallen.tyrael.repositories.WorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class WorkService implements BaseService<Work>{
  
  @Autowired
  private WorkRepository workRepository;

  @Override
  public List<Work> findAll() {
    return workRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
  }

  @Override
  public Work findById(Long id) {
    return workRepository.findById(id).orElse(null);
  }

  @Override
  public Work create(Work obj) {
    return workRepository.save(obj);
  }

  @Override
  public Work update(Long id, Work obj) {
    Work work = workRepository.findById(id).orElse(null);
    if (work != null) {
      work.setName(obj.getName());
      work.setSub(obj.getSub());
      work.setTechnology(obj.getTechnology());
      work.setCompany(obj.getCompany());
      work.setDescription(obj.getDescription());
      return workRepository.save(work);
    }
    return work;
  }
}
