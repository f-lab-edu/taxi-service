package com.giwankim.taxiservice.client.fare.kakao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.giwankim.taxiservice.core.domain.domain.KRWMoney;
import java.util.List;

@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
record KakaoFareResponse(List<Route> routes) {
  KRWMoney toBaseFare() {
    return KRWMoney.wons(routes().getFirst().summary().fare().taxi());
  }

  @JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
  @JsonIgnoreProperties(ignoreUnknown = true)
  record Route(Summary summary) {

    @JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
    @JsonIgnoreProperties(ignoreUnknown = true)
    record Summary(Fare fare) {
      record Fare(int taxi, int toll) {}
    }
  }
}
