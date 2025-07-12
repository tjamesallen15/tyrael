package org.jallen.tyrael.base;

import java.util.List;

public interface BaseMapper<T> {
  public List<T> getMapping(List<T> obj);
  public T getMapping(T origin, T obj);
}
