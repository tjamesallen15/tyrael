package org.jallen.tyrael.entity;

import java.util.Optional;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Employee {
  private Integer id;
  private Optional<String> name;
  private Optional<Double> salary;

  public Employee(Integer id, Optional<String> name, Optional<Double> salary) {
    this.setId(id);
    this.setName(name);
    this.setSalary(salary);
  }
}
