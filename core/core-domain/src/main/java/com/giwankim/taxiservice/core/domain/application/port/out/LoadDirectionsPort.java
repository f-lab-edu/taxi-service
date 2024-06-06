package com.giwankim.taxiservice.core.domain.application.port.out;

import com.giwankim.taxiservice.core.domain.domain.Directions;
import com.giwankim.taxiservice.core.domain.domain.Location;

public interface LoadDirectionsPort {
  Directions loadDirections(Location origin, Location destination);
}
