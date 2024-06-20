package com.giwankim.taxiservice.core.domain.application.service;

import static com.giwankim.taxiservice.domain.Fixtures.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import com.giwankim.taxiservice.core.domain.application.port.in.GetTripEstimatesQuery;
import com.giwankim.taxiservice.core.domain.application.port.in.TripEstimates;
import com.giwankim.taxiservice.core.domain.application.port.out.LoadBaseFarePort;
import com.giwankim.taxiservice.core.domain.application.port.out.LoadDirectionsPort;
import com.giwankim.taxiservice.core.domain.domain.*;
import org.junit.jupiter.api.Test;

class GetTripEstimatesServiceTest {
  private final LoadDirectionsPort loadDirectionsPort = mock(LoadDirectionsPort.class);

  private final LoadBaseFarePort loadBaseFarePort = mock(LoadBaseFarePort.class);

  private final GetTripEstimatesService sut =
      new GetTripEstimatesService(loadDirectionsPort, loadBaseFarePort);

  @Test
  void shouldGetTripEstimates() {
    Location origin = anOrigin().build();
    Location destination = aDestination().build();
    Directions directions = givenDirectionsLoaded(origin, destination);
    KRWMoney baseFareLoaded = givenBaseFareLoaded(origin, destination);

    GetTripEstimatesQuery query = new GetTripEstimatesQuery(origin, destination);
    TripEstimates tripEstimates = sut.getTripEstimates(query);

    assertThat(tripEstimates.getEstimates()).hasSize(TaxiType.values().length);
    assertThat(tripEstimates.findByTaxiType(TaxiType.REGULAR))
        .contains(TripEstimate.of(TaxiType.REGULAR, baseFareLoaded, directions));
    assertThat(tripEstimates.findByTaxiType(TaxiType.DELUXE))
        .contains(TripEstimate.of(TaxiType.DELUXE, baseFareLoaded, directions));
    assertThat(tripEstimates.findByTaxiType(TaxiType.JUMBO))
        .contains(TripEstimate.of(TaxiType.JUMBO, baseFareLoaded, directions));
  }

  private Directions givenDirectionsLoaded(Location origin, Location destination) {
    Directions directions = aDirections().build();
    given(loadDirectionsPort.loadDirections(origin, destination)).willReturn(directions);
    return directions;
  }

  private KRWMoney givenBaseFareLoaded(Location origin, Location destination) {
    KRWMoney baseFare = KRWMoney.wons(10_000);
    given(loadBaseFarePort.loadBaseFare(origin, destination)).willReturn(baseFare);
    return baseFare;
  }
}
