package de.mankianer.mankisweckerservice.models;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Wecker {

  @Id
  @GeneratedValue
  private Integer id;

  @Column(nullable = false)
  private LocalDateTime dateTime;

  private String config;
}
