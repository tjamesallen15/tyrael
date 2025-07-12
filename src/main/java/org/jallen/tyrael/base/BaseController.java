package org.jallen.tyrael.base;

import java.util.List;
import org.springframework.http.ResponseEntity;

public interface BaseController<T> {
  public ResponseEntity<List<T>> findAll();
  public ResponseEntity<T> findById(Long id);
  public ResponseEntity<T> create(T obj);
  public ResponseEntity<T> update(Long id, T obj);
  public ResponseEntity<?> delete(Long id);
}
