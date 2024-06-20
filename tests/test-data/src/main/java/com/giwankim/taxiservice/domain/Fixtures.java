package com.giwankim.taxiservice.domain;

import com.giwankim.taxiservice.core.domain.application.port.in.TripEstimates;
import com.giwankim.taxiservice.core.domain.application.port.in.TripEstimates.TripEstimatesBuilder;
import com.giwankim.taxiservice.core.domain.domain.*;
import com.giwankim.taxiservice.core.domain.domain.Directions.DirectionsBuilder;
import com.giwankim.taxiservice.core.domain.domain.Location.LocationBuilder;
import java.util.Arrays;

public class Fixtures {
  private Fixtures() {}

  public static LocationBuilder aLocation() {
    return Location.builder().latitude(37.394725518530834).longitude(127.11015051307636);
  }

  public static LocationBuilder anOrigin() {
    return Location.builder()
        .name("출발지")
        .latitude(37.394725518530834)
        .longitude(127.11015051307636);
  }

  public static LocationBuilder aDestination() {
    return Location.builder()
        .name("도착지")
        .latitude(37.401928707331656)
        .longitude(127.10823557165544);
  }

  public static DirectionsBuilder aDirections() {
    return Directions.builder()
        .origin(anOrigin().build())
        .destination(aDestination().build())
        .distance(1033)
        .duration(320);
  }

  public static TripEstimatesBuilder aTripEstimates() {
    KRWMoney baseFare = KRWMoney.wons(3800);
    Directions directions = aDirections().build();
    return TripEstimates.builder()
        .estimates(
            Arrays.asList(
                TripEstimate.of(TaxiType.REGULAR, baseFare, directions),
                TripEstimate.of(TaxiType.DELUXE, baseFare, directions),
                TripEstimate.of(TaxiType.JUMBO, baseFare, directions)));
  }
}
