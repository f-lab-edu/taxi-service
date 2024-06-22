package com.giwankim.taxiservice.core.domain.application.port.in;

public interface GetTripEstimatesUseCase {
  TripEstimates getTripEstimates(GetTripEstimatesQuery query);
}
