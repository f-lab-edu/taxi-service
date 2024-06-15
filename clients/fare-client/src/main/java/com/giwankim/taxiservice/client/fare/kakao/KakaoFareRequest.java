package com.giwankim.taxiservice.client.fare.kakao;

import com.giwankim.taxiservice.core.domain.domain.Location;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KakaoFareRequest {
  private String origin;
  private String destination;

  public KakaoFareRequest(String origin, String destination) {
    this.origin = origin;
    this.destination = destination;
  }

  public KakaoFareRequest(Location origin, Location destination) {
    this(
        origin.getLongitude() + "," + origin.getLatitude(),
        destination.getLongitude() + "," + destination.getLatitude());
  }
}
