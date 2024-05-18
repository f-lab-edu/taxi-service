package com.giwankim.taxiservice.client.location;

import com.giwankim.taxiservice.core.domain.application.port.out.SearchLocationPort;
import com.giwankim.taxiservice.core.domain.domain.Location;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.IntStream;

@Component
public class DummyLocationClient implements SearchLocationPort {

  @Override
  public List<Location> searchLocations(String keyword, int page, int size) {
    return IntStream.range(0, size)
      .mapToObj(i -> new Location("위치" + i, 37.0 + i, 127.0 + i))
      .toList();
  }
}
