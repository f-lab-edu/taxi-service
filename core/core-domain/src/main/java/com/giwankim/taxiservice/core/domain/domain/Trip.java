package com.giwankim.taxiservice.core.domain.domain;

import lombok.Getter;

@Getter
public class Trip {
  private TripId id;
  private TripStatus status;
  private Driver driver;
  private Passenger passenger;
  private Vehicle vehicle;
  private Location pickup;
  private Location dropoff;

  public record TripId(Long value) {}
}
