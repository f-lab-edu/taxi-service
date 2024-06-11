package com.giwankim.taxiservice.client.fare.kakao;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import com.giwankim.taxiservice.client.FareClientFixture;
import com.giwankim.taxiservice.core.domain.domain.Location;
import com.giwankim.taxiservice.core.domain.domain.Money;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

@SpringBootTest
@WireMockTest(httpPort = 8091)
class KakaoFareClientTest {
  @Autowired private KakaoFareClient kakaoFareClient;

  @Test
  void getFare() {
    String urlPath = "/v1/directions";
    stubFor(
        get(urlPathEqualTo(urlPath))
            .withHeader("Authorization", matching(".*"))
            .withQueryParam("origin", matching(".*"))
            .withQueryParam("destination", matching(".*"))
            .willReturn(
                aResponse()
                    .withBody(FareClientFixture.KAKAO_FARE_SUCCESS_RESPONSE_BODY)
                    .withHeader(CONTENT_TYPE, APPLICATION_JSON_VALUE)
                    .withStatus(HttpStatus.OK.value())));

    Location origin = new Location("출발지", 37.394725518530834, 127.11015051307636);
    Location destination = new Location("도착지", 37.401928707331656, 127.10823557165544);

    Money baseFare = kakaoFareClient.loadBaseFare(origin, destination);

    verify(getRequestedFor(urlPathEqualTo(urlPath)));
    assertThat(baseFare).isEqualTo(Money.wons(5200));
  }
}
