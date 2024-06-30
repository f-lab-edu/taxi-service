package com.giwankim.taxiservice.core.domain.application.port.out;

import com.giwankim.taxiservice.core.domain.domain.Driver;
import com.giwankim.taxiservice.core.domain.domain.Location;
import java.util.List;

public interface LoadDriversPort {
  List<Driver> loadDriversNear(Location location, double distance);
}
