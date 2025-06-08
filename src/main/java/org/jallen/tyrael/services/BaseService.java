package org.jallen.tyrael.services;

import java.util.List;

public interface BaseService<T> {
  public List<T> findAll();
  public T findById(Long id);
  public T create(T obj);
  public T update(Long id, T obj);
  public void delete(Long id);
}
