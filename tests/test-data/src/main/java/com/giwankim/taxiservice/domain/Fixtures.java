package com.giwankim.taxiservice.domain;

import com.giwankim.taxiservice.core.domain.application.port.in.TripEstimates;
import com.giwankim.taxiservice.core.domain.application.port.in.TripEstimates.TripEstimatesBuilder;
import com.giwankim.taxiservice.core.domain.domain.*;
import com.giwankim.taxiservice.core.domain.domain.Directions.DirectionsBuilder;
import com.giwankim.taxiservice.core.domain.domain.KRWMoney;
import com.giwankim.taxiservice.core.domain.domain.Location;
import com.giwankim.taxiservice.core.domain.domain.Location.LocationBuilder;
import com.giwankim.taxiservice.core.domain.domain.Passenger.PassengerBuilder;
import com.giwankim.taxiservice.core.domain.domain.PickupRequest.PickupRequestBuilder;
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

  public static PassengerBuilder aPassenger() {
    return Passenger.builder()
        .id(new Passenger.PassengerId(1L))
        .username("홍길동")
        .password("secret-password")
        .phoneNumber("01012345678");
  }

  public static PickupRequestBuilder aPickupRequest() {
    return PickupRequest.builder()
        .id(new PickupRequest.RequestId("806776b0-446f-455b-9eb1-739ab088a244"))
        .status(PickupRequestStatus.SUBMITTED)
        .passenger(aPassenger().build())
        .pickup(anOrigin().build())
        .dropoff(aDestination().build())
        .taxiType(TaxiType.REGULAR);
  }
}
