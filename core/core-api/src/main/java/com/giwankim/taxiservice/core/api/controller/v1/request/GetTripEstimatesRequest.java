package com.giwankim.taxiservice.core.api.controller.v1.request;

import com.giwankim.taxiservice.core.domain.domain.Location;

public record GetTripEstimatesRequest(
    @LongitudeLatitude String origin, @LongitudeLatitude String destination) {
  public Location originToLocation() {
    return toLocation(origin);
  }

  public Location destinationToLocation() {
    return toLocation(destination);
  }

  private static Location toLocation(String value) {
    String[] parts = value.split(",", 2);
    double longitude = Double.parseDouble(parts[0]);
    double latitude = Double.parseDouble(parts[1]);
    return new Location(null, latitude, longitude);
  }
}
