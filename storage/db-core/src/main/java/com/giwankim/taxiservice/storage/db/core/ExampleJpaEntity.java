package com.giwankim.taxiservice.storage.db.core;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "EXAMPLE")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class ExampleJpaEntity extends BaseEntity {

  @Column(name = "EXAMPLE_COLUMN")
  private String exampleColumn;
}
