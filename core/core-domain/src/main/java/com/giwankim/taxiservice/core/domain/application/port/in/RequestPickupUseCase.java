package com.giwankim.taxiservice.core.domain.application.port.in;

import com.giwankim.taxiservice.core.domain.domain.PickupRequest;

public interface RequestPickupUseCase {
  PickupRequest requestPickup(RequestPickupCommand command);
}
