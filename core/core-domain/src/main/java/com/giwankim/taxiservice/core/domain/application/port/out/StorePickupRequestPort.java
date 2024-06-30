package com.giwankim.taxiservice.core.domain.application.port.out;

import com.giwankim.taxiservice.core.domain.domain.PickupRequest;

public interface StorePickupRequestPort {
  PickupRequest storePickupRequest(PickupRequest pickupRequest);
}
