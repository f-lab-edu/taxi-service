package com.giwankim.taxiservice.core.domain.application.port.in;

import com.giwankim.taxiservice.core.domain.domain.Location;

public record GetTripEstimatesQuery(Location origin, Location destination) {}
