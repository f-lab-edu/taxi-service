package com.giwankim.taxiservice.client.location.kakao;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;

import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import com.giwankim.taxiservice.client.FileUtils;
import com.giwankim.taxiservice.core.domain.domain.Location;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

@SpringBootTest
@WireMockTest(httpPort = 8089)
class KakaoLocationClientTest {

  @Autowired private KakaoLocationClient kakaoLocationClient;

  @Test
  void searchLocations() {
    String address = "전북 삼성동 100";
    String urlPath = "/search/address.json";
    stubFor(
        get(urlPathEqualTo(urlPath))
            .withQueryParam("query", equalTo(address))
            .willReturn(
                aResponse()
                    .withBody(FileUtils.read("classpath:kakao-location-response.json"))
                    .withHeader(CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                    .withStatus(HttpStatus.OK.value())));

    List<Location> actualLocations = kakaoLocationClient.searchLocations(address, 1, 3);

    List<Location> expectedLocations =
        List.of(
            new Location("전북특별자치도 익산시 부송동 100", 35.9766482774572, 126.99597495347),
            new Location("전북특별자치도 익산시 임상동 100", 35.9816612949048, 126.980268573424),
            new Location("전북특별자치도 익산시 정족동 100", 35.9829740190917, 127.002020445866));
    assertThat(actualLocations).containsExactlyElementsOf(expectedLocations);
    verify(getRequestedFor(urlPathEqualTo(urlPath)).withQueryParam("query", equalTo(address)));
  }
}
