package com.giwankim.taxiservice.core.domain.application.service;

import com.giwankim.taxiservice.core.domain.application.port.in.SearchLocationsQuery;
import com.giwankim.taxiservice.core.domain.application.port.in.SearchLocationsUseCase;
import com.giwankim.taxiservice.core.domain.application.port.out.SearchLocationPort;
import com.giwankim.taxiservice.core.domain.domain.Location;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SearchLocationsService implements SearchLocationsUseCase {

  private final SearchLocationPort searchLocationPort;

  @Override
  public List<Location> searchLocations(SearchLocationsQuery query) {
    return searchLocationPort.searchLocations(query.keyword(), query.page(), query.size());
  }
}
