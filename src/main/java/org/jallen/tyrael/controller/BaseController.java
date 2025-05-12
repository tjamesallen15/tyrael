package org.jallen.tyrael.controller;

import java.util.List;

public interface BaseController<T> {
  public List<T> findAll();
  public T findById(Long id);
  public T create(T obj);
  public T update(Long id, T obj);
}
