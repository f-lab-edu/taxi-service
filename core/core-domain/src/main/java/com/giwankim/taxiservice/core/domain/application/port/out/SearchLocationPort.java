package com.giwankim.taxiservice.core.domain.application.port.out;

import com.giwankim.taxiservice.core.domain.domain.Location;

import java.util.List;

public interface SearchLocationPort {

  List<Location> searchLocations(String keyword);

}
