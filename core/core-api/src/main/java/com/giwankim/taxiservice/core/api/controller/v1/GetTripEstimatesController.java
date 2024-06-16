package com.giwankim.taxiservice.core.api.controller.v1;

import com.giwankim.taxiservice.core.api.controller.v1.request.GetTripEstimatesRequest;
import com.giwankim.taxiservice.core.api.controller.v1.response.TripEstimatesResponse;
import com.giwankim.taxiservice.core.api.support.response.ApiResponse;
import com.giwankim.taxiservice.core.domain.application.port.in.GetTripEstimatesQuery;
import com.giwankim.taxiservice.core.domain.application.port.in.GetTripEstimatesUseCase;
import com.giwankim.taxiservice.core.domain.domain.TripEstimates;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GetTripEstimatesController {
  private final GetTripEstimatesUseCase getTripEstimatesUseCase;

  @GetMapping(value = "/v1/trip/estimate")
  ApiResponse<TripEstimatesResponse> getTripEstimates(@Valid GetTripEstimatesRequest request) {
    GetTripEstimatesQuery query =
        new GetTripEstimatesQuery(request.originToLocation(), request.destinationToLocation());
    TripEstimates tripEstimates = getTripEstimatesUseCase.getTripEstimates(query);
    return ApiResponse.success(TripEstimatesResponse.from(tripEstimates));
  }
}
