package com.giwankim.taxiservice.core.domain.application.port.out;

import com.giwankim.taxiservice.core.domain.domain.PickupRequest;

public interface LoadPickupRequestPort {
  PickupRequest loadPickupRequest(PickupRequest.RequestId id);
}
