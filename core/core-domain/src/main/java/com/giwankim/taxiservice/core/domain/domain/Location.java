package com.giwankim.taxiservice.core.domain.domain;

import lombok.Builder;
import lombok.Getter;

import java.util.Objects;

@Getter
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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Location location)) return false;
    return Double.compare(latitude, location.latitude) == 0 && Double.compare(longitude, location.longitude) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(latitude, longitude);
  }

  @Override
  public String toString() {
    return "Location{" +
      "name='" + name + '\'' +
      ", latitude=" + latitude +
      ", longitude=" + longitude +
      '}';
  }
}
