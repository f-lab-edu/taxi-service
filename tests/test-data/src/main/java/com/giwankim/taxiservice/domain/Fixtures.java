package com.giwankim.taxiservice.domain;

import com.giwankim.taxiservice.core.domain.domain.*;
import com.giwankim.taxiservice.core.domain.domain.Directions.DirectionsBuilder;
import com.giwankim.taxiservice.core.domain.domain.Location.LocationBuilder;
import com.giwankim.taxiservice.core.domain.domain.TripEstimates.TripEstimatesBuilder;
import com.giwankim.taxiservice.core.enums.TaxiType;
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
    return TripEstimates.builder()
        .baseFare(baseFare)
        .directions(aDirections().build())
        .estimates(
            Arrays.asList(
                TripEstimate.create(TaxiType.REGULAR, baseFare),
                TripEstimate.create(TaxiType.DELUXE, baseFare),
                TripEstimate.create(TaxiType.JUMBO, baseFare)));
  }
}
