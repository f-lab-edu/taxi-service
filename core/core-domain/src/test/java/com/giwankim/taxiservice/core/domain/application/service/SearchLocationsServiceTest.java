package com.giwankim.taxiservice.core.domain.application.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import com.giwankim.taxiservice.core.domain.application.port.in.SearchLocationsQuery;
import com.giwankim.taxiservice.core.domain.application.port.out.SearchLocationPort;
import com.giwankim.taxiservice.core.domain.domain.Location;
import java.util.List;
import org.junit.jupiter.api.Test;

class SearchLocationsServiceTest {

  private final SearchLocationPort searchLocationPort = mock(SearchLocationPort.class);

  private final SearchLocationsService sut = new SearchLocationsService(searchLocationPort);

  @Test
  void shouldFindLocations() {
    List<Location> locations =
        List.of(
            Location.builder().name("강남역").latitude(37.496486063).longitude(127.028361548).build(),
            Location.builder().name("판교역").latitude(37.394726159).longitude(127.111209047).build());

    given(searchLocationPort.searchLocations("역", 1, 2)).willReturn(locations);

    List<Location> actual = sut.searchLocations(new SearchLocationsQuery("역", 1, 2));

    assertThat(actual).containsExactlyInAnyOrderElementsOf(locations);
  }
}
