package com.giwankim.taxiservice.core.domain.application.port.out;

import com.giwankim.taxiservice.core.domain.domain.KRWMoney;
import com.giwankim.taxiservice.core.domain.domain.Location;

public interface LoadBaseFarePort {
  KRWMoney loadBaseFare(Location origin, Location destination);
}
