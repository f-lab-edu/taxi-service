package com.giwankim.taxiservice.core.api.controller.v1.response;

import com.giwankim.taxiservice.core.domain.domain.Location;

import java.util.List;

public record LocationResponse(String name, double latitude, double longitude) {
  public LocationResponse(Location location) {
    this(location.getName(), location.getLatitude(), location.getLongitude());
  }

  public static List<LocationResponse> of(List<Location> locations) {
    return locations.stream()
      .map(LocationResponse::new)
      .toList();
  }
}
