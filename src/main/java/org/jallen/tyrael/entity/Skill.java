package org.jallen.tyrael.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "skill")
public class Skill {

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "skill_seq")
  @SequenceGenerator(name = "skill_seq", sequenceName = "skill_seq", allocationSize = 1)
  private Long id;

  @Column(columnDefinition = "TEXT")
  private String name;

  @Column(columnDefinition = "TEXT")
  private Long experience;

  @Column(columnDefinition = "TEXT")
  private String description;

  @Column(columnDefinition = "TEXT")
  private String type;
}
