package com.giwankim.taxiservice.core.domain.application.port.in;

import com.giwankim.taxiservice.core.domain.domain.Location;
import com.giwankim.taxiservice.core.domain.domain.Passenger;
import com.giwankim.taxiservice.core.domain.domain.PickupRequest;
import com.giwankim.taxiservice.core.domain.domain.TaxiType;

public record RequestPickupCommand(
    Passenger passenger, Location pickup, Location dropoff, TaxiType taxiType, Long ttlInSeconds) {
  public PickupRequest toPickupRequest() {
    return new PickupRequest(passenger, pickup, dropoff, taxiType);
  }
}
