package com.giwankim.taxiservice.client.directions.kakao;

import com.giwankim.taxiservice.core.domain.domain.Location;

public record KakaoDirectionsRequest(String origin, String destination) {
  KakaoDirectionsRequest(Location origin, Location destination) {
    this(
        origin.getLongitude() + "," + origin.getLatitude(),
        destination.getLongitude() + "," + destination.getLatitude());
  }
}
