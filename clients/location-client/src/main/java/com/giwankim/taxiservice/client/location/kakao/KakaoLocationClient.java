package com.giwankim.taxiservice.client.location.kakao;

import com.giwankim.taxiservice.core.domain.application.port.out.SearchLocationPort;
import com.giwankim.taxiservice.core.domain.domain.Location;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
class KakaoLocationClient implements SearchLocationPort {

  private final KakaoLocationApi locationApi;

  @Override
  public List<Location> searchLocations(String keyword, int page, int size) {
    KakaoLocationRequest request = new KakaoLocationRequest(keyword, page, size);
    return locationApi.searchLocations(request).toLocations();
  }
}
