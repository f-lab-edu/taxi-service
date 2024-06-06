package com.giwankim.taxiservice.client.fare.kakao;

import com.giwankim.taxiservice.core.domain.application.port.out.LoadBaseFarePort;
import com.giwankim.taxiservice.core.domain.domain.Location;
import com.giwankim.taxiservice.core.domain.domain.Money;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class KakaoFareClient implements LoadBaseFarePort {
  private final KakaoFareApi fareApi;

  @Override
  public Money loadBaseFare(Location origin, Location destination) {
    KakaoFareRequest request = new KakaoFareRequest(origin, destination);
    return fareApi.getFare(request).toBaseFare();
  }
}
