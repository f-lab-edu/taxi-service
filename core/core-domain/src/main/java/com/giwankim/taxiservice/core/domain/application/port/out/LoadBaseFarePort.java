package com.giwankim.taxiservice.core.domain.application.port.out;

import com.giwankim.taxiservice.core.domain.domain.Location;
import com.giwankim.taxiservice.core.domain.domain.Money;

public interface LoadBaseFarePort {
  Money loadBaseFare(Location origin, Location destination);
}
