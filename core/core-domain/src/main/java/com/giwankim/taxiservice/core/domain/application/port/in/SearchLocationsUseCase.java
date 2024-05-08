package com.giwankim.taxiservice.core.domain.application.port.in;

import com.giwankim.taxiservice.core.domain.domain.Location;

import java.util.List;

public interface SearchLocationsUseCase {

  List<Location> searchLocations(SearchLocationsQuery query);

  record SearchLocationsQuery(String keyword, int page, int size) {
  }
}
