package com.giwankim.taxiservice.client.location.kakao;

import com.giwankim.taxiservice.core.domain.application.port.out.SearchLocationPort;
import com.giwankim.taxiservice.core.domain.domain.Location;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class KakaoLocationClient implements SearchLocationPort {

  private final KakaoLocationApi locationApi;
  private final KakaoLocationMapper locationMapper;

  public KakaoLocationClient(KakaoLocationApi locationApi, KakaoLocationMapper locationMapper) {
    this.locationApi = locationApi;
    this.locationMapper = locationMapper;
  }

  @Override
  public List<Location> searchLocations(String keyword, int page, int size) {
    KakaoLocationRequest request = new KakaoLocationRequest(keyword, page, size);
    KakaoLocationResponse response = locationApi.searchLocations(request);
    return locationMapper.mapToLocations(response);
  }
}
