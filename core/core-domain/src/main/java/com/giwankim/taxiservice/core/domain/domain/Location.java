package com.giwankim.taxiservice.core.domain.domain;

import lombok.Builder;

public class Location {
  private final String name;
  private final double latitude;
  private final double longitude;

  @Builder
  public Location(String name, double latitude, double longitude) {
    this.name = name;
    this.latitude = latitude;
    this.longitude = longitude;
  }
}
