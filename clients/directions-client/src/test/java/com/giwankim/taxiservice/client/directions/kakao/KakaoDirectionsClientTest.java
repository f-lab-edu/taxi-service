package com.giwankim.taxiservice.client.directions.kakao;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import com.giwankim.taxiservice.client.directions.FileUtils;
import com.giwankim.taxiservice.core.domain.domain.Directions;
import com.giwankim.taxiservice.core.domain.domain.Location;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

@SpringBootTest
@WireMockTest(httpPort = 8090)
class KakaoDirectionsClientTest {

  @Autowired KakaoDirectionsClient kakaoDirectionsClient;

  @Test
  void loadDirections() {
    String urlPath = "/v1/directions";
    stubFor(
        get(urlPathEqualTo(urlPath))
            .withQueryParam("origin", matching("^(-?\\d+(\\.\\d+)?),(-?\\d+(\\.\\d+)?)$"))
            .withQueryParam("destination", matching("^(-?\\d+(\\.\\d+)?),(-?\\d+(\\.\\d+)?)$"))
            .willReturn(
                aResponse()
                    .withBody(FileUtils.read("classpath:kakao-directions-response.json"))
                    .withHeader(CONTENT_TYPE, APPLICATION_JSON_VALUE)
                    .withStatus(HttpStatus.OK.value())));

    Location origin = new Location("출발지", 37.394725518530834, 127.11015051307636);
    Location destination = new Location("도착지", 37.401928707331656, 127.10823557165544);

    Directions directions = kakaoDirectionsClient.loadDirections(origin, destination);

    Directions expectedDirections = new Directions(origin, destination, 1033, 320);
    assertThat(directions).isEqualTo(expectedDirections);
    verify(getRequestedFor(urlPathEqualTo(urlPath)));
  }
}
