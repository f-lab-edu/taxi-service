package com.giwankim.taxiservice.core.api.controller.v1.response;

import com.giwankim.taxiservice.core.domain.domain.Directions;
import com.giwankim.taxiservice.core.domain.domain.TripEstimate;
import com.giwankim.taxiservice.core.domain.domain.TripEstimates;
import com.giwankim.taxiservice.core.enums.TaxiType;
import java.util.List;

public record TripEstimatesResponse(
    LocationResponse origin,
    LocationResponse destination,
    long distance,
    long duration,
    List<TripEstimateResponse> estimates) {
  public static TripEstimatesResponse from(TripEstimates tripEstimates) {
    Directions directions = tripEstimates.getDirections();
    List<TripEstimateResponse> estimateResponses =
        tripEstimates.getEstimates().stream()
            .map(tripEstimate -> TripEstimateResponse.of(tripEstimate, directions))
            .toList();
    return new TripEstimatesResponse(
        new LocationResponse(directions.getOrigin()),
        new LocationResponse(directions.getDestination()),
        directions.getDistance(),
        directions.getDuration(),
        estimateResponses);
  }

  record TripEstimateResponse(TaxiType taxiType, long fare) {
    public static TripEstimateResponse of(TripEstimate tripEstimate, Directions directions) {
      return new TripEstimateResponse(
          tripEstimate.getTaxiType(), tripEstimate.calculateTotalFare(directions).longValue());
    }
  }
}
