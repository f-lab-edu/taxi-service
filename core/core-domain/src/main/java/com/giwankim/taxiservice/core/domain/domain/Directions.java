package com.giwankim.taxiservice.core.domain.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Getter
public class Directions {
  private final Location origin;
  private final Location destination;
  private final int distance;
  private final int duration;

  @Builder
  public Directions(Location origin, Location destination, int distance, int duration) {
    this.origin = origin;
    this.destination = destination;
    this.distance = distance;
    this.duration = duration;
  }
}
