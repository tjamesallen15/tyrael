package org.jallen.tyrael.base;

import java.util.List;
import java.util.Optional;

public interface BaseService<T> {
  public List<T> findAll();
  public Optional<T> findById(Long id);
  public T create(T obj);
  public T update(Long id, T obj);
  public void delete(Long id);
}
