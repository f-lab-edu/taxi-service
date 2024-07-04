package com.giwankim.taxiservice.core.domain.application.port.out;

import com.giwankim.taxiservice.core.domain.domain.Driver;

public interface DriverLock {
  void lockDriver(Driver.DriverId driverId);

  void releaseDriver(Driver.DriverId driverId);
}
