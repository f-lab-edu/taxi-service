package com.giwankim.taxiservice.core.domain.application.service;

import com.giwankim.taxiservice.common.UseCase;
import com.giwankim.taxiservice.core.domain.application.port.in.SearchLocationsQuery;
import com.giwankim.taxiservice.core.domain.application.port.in.SearchLocationsUseCase;
import com.giwankim.taxiservice.core.domain.application.port.out.SearchLocationPort;
import com.giwankim.taxiservice.core.domain.domain.Location;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@UseCase
public class SearchLocationsService implements SearchLocationsUseCase {

  private final SearchLocationPort searchLocationPort;

  @Override
  public List<Location> searchLocations(SearchLocationsQuery query) {
    return searchLocationPort.searchLocations(query.getKeyword());
  }
}
