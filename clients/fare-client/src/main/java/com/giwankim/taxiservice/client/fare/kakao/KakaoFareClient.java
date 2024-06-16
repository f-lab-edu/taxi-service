package com.giwankim.taxiservice.client.fare.kakao;

import com.giwankim.taxiservice.core.domain.application.port.out.LoadBaseFarePort;
import com.giwankim.taxiservice.core.domain.domain.KRWMoney;
import com.giwankim.taxiservice.core.domain.domain.Location;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class KakaoFareClient implements LoadBaseFarePort {
  private final KakaoFareApi fareApi;

  @Override
  public KRWMoney loadBaseFare(Location origin, Location destination) {
    KakaoFareRequest request = new KakaoFareRequest(origin, destination);
    return fareApi.getFare(request).toBaseFare();
  }
}
