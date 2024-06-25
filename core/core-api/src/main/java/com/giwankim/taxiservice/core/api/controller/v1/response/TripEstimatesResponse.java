package com.giwankim.taxiservice.core.api.controller.v1.response;

import com.giwankim.taxiservice.core.domain.application.port.in.TripEstimates;
import com.giwankim.taxiservice.core.domain.domain.TaxiType;
import com.giwankim.taxiservice.core.domain.domain.TripEstimate;
import java.util.List;

public record TripEstimatesResponse(List<TripEstimateResponse> estimates) {
  public static TripEstimatesResponse from(TripEstimates tripEstimates) {
    List<TripEstimateResponse> estimateResponses =
        tripEstimates.getEstimates().stream().map(TripEstimateResponse::from).toList();
    return new TripEstimatesResponse(estimateResponses);
  }

  record TripEstimateResponse(
      TaxiType taxiType,
      long fare,
      LocationResponse origin,
      LocationResponse destination,
      long distance,
      long duration) {
    public static TripEstimateResponse from(TripEstimate tripEstimate) {
      return new TripEstimateResponse(
          tripEstimate.getTaxiType(),
          tripEstimate.calculateTotalFare(tripEstimate.getDirections()).longValue(),
          new LocationResponse(tripEstimate.getDirections().getOrigin()),
          new LocationResponse(tripEstimate.getDirections().getDestination()),
          tripEstimate.getDirections().getDistance(),
          tripEstimate.getDirections().getDuration());
    }
  }
}
