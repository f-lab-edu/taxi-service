package com.giwankim.taxiservice.core.domain.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Vehicle {
  private final String make;
  private final String model;
  private final String licensePlate;

  @Builder
  public Vehicle(String make, String model, String licensePlate) {
    this.make = make;
    this.model = model;
    this.licensePlate = licensePlate;
  }
}
