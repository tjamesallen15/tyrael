package org.jallen.tyrael.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "work")
public class Work {

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(columnDefinition = "TEXT")
  private String name;

  @Column(columnDefinition = "TEXT")
  private String sub;

  @Column(columnDefinition = "TEXT")
  private String technology;

  @Column(columnDefinition = "TEXT")
  private String company;

  @Column(columnDefinition = "TEXT")
  private String description;
}
