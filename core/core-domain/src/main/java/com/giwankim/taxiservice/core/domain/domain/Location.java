package com.giwankim.taxiservice.core.domain.domain;

import lombok.Builder;
import lombok.Value;

@Value
public class Location {
  String name;
  double latitude;
  double longitude;

  @Builder
  public Location(String name, double latitude, double longitude) {
    this.name = name;
    this.latitude = latitude;
    this.longitude = longitude;
  }
}
