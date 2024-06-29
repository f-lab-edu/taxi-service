package com.giwankim.taxiservice.core.domain.domain;

import java.net.URL;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Driver {
  private final DriverId id;
  private final Vehicle vehicle;
  private final String name;
  private final String phoneNumber;
  private final URL profilePicture;
  private final Location location;

  @Builder
  public Driver(
      DriverId id,
      Vehicle vehicle,
      String name,
      String phoneNumber,
      URL profilePicture,
      Location location) {
    this.id = id;
    this.vehicle = vehicle;
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.profilePicture = profilePicture;
    this.location = location;
  }

  public record DriverId(Long value) {}
}
