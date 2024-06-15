package com.giwankim.taxiservice.core.domain.application.port.in;

import com.giwankim.taxiservice.core.domain.domain.TripEstimates;

public interface GetTripEstimatesUseCase {
  TripEstimates getTripEstimates(GetTripEstimatesQuery query);
}
