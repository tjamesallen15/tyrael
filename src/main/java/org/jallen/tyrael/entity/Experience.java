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
@Table(name = "experience")
public class Experience {

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(columnDefinition = "TEXT")
  private String company;

  @Column(columnDefinition = "TEXT")
  private String position;

  @Column(columnDefinition = "TEXT")
  private String duration;

  @Column(columnDefinition = "TEXT")
  private String total;

  @Column(columnDefinition = "TEXT")
  private String location;

  @Column(columnDefinition = "TEXT")
  private String description;
}
