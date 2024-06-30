package com.giwankim.taxiservice.core.domain.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class PickupRequest {
  private final RequestId id;
  private final PickupRequestStatus status;
  private final Passenger passenger;
  private final Location pickup;
  private final Location dropoff;
  private final TaxiType taxiType;

  @Builder
  public PickupRequest(
      RequestId id,
      PickupRequestStatus status,
      Passenger passenger,
      Location pickup,
      Location dropoff,
      TaxiType taxiType) {
    this.id = id;
    this.status = status;
    this.passenger = passenger;
    this.pickup = pickup;
    this.dropoff = dropoff;
    this.taxiType = taxiType;
  }

  public PickupRequest(Passenger passenger, Location pickup, Location dropoff, TaxiType taxiType) {
    this(null, PickupRequestStatus.SUBMITTED, passenger, pickup, dropoff, taxiType);
  }

  public record RequestId(String value) {}
}
