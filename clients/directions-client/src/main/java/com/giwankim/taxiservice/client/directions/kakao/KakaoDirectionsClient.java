package com.giwankim.taxiservice.client.directions.kakao;

import com.giwankim.taxiservice.core.domain.application.port.out.LoadDirectionsPort;
import com.giwankim.taxiservice.core.domain.domain.Directions;
import com.giwankim.taxiservice.core.domain.domain.Location;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class KakaoDirectionsClient implements LoadDirectionsPort {
  private final KakaoDirectionsApi directionsApi;

  @Override
  public Directions loadDirections(Location origin, Location destination) {
    KakaoDirectionsRequest request = new KakaoDirectionsRequest(origin, destination);
    KakaoDirectionsResponse response =
        directionsApi.getDirections(request.origin(), request.destination());
    return response.toDirections();
  }
}
