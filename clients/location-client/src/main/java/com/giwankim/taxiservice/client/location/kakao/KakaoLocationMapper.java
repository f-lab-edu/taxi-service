package com.giwankim.taxiservice.client.location.kakao;

import com.giwankim.taxiservice.core.domain.domain.Location;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class KakaoLocationMapper {

  List<Location> mapToLocations(KakaoLocationResponse response) {
    return response.documents()
      .stream()
      .map(document ->
        new Location(
          document.addressName(),
          document.y(),
          document.x()))
      .toList();
  }
}
