package com.giwankim.taxiservice.client.location;

import com.giwankim.taxiservice.core.domain.domain.Location;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LocationMapper {

  List<Location> mapToLocations(LocationsResponse response) {
    return response.documents()
      .stream()
      .map(document ->
        new Location(
          document.addressName(),
          Double.parseDouble(document.x()),
          Double.parseDouble(document.y())))
      .toList();
  }
}
