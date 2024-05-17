package com.giwankim.taxiservice.client.location;

import com.giwankim.taxiservice.core.domain.application.port.out.SearchLocationPort;
import com.giwankim.taxiservice.core.domain.domain.Location;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class LocationClient implements SearchLocationPort {

  private final LocationApi locationApi;

  private final LocationMapper locationMapper;

  @Override
  public List<Location> searchLocations(String keyword, int page, int size) {

    LocationRequest request = new LocationRequest(keyword, page, size);

    LocationsResponse response = locationApi.searchLocations(request);

    return locationMapper.mapToLocations(response);
  }
}
