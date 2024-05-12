package com.giwankim.taxiservice.core.api.controller.v1;

import com.giwankim.taxiservice.core.api.controller.v1.request.SearchLocationRequest;
import com.giwankim.taxiservice.core.api.controller.v1.response.LocationResponse;
import com.giwankim.taxiservice.core.api.support.response.ApiResponse;
import com.giwankim.taxiservice.core.domain.application.port.in.SearchLocationsUseCase;
import com.giwankim.taxiservice.core.domain.application.port.in.SearchLocationsUseCase.SearchLocationsQuery;
import com.giwankim.taxiservice.core.domain.domain.Location;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SearchLocationsController {

  private final SearchLocationsUseCase searchLocationsUseCase;

  @GetMapping(value = "/location/search")
  ApiResponse<List<LocationResponse>> searchLocations(
    @Valid SearchLocationRequest request
  ) {

    SearchLocationsQuery query = new SearchLocationsQuery(request.getKeyword(), request.getPage(), request.getSize());

    List<Location> locations = searchLocationsUseCase.searchLocations(query);

    return ApiResponse.success(LocationResponse.of(locations));
  }
}

