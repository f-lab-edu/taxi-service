package com.giwankim.taxiservice.client.directions.kakao;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange(url = "/v1/directions", contentType = APPLICATION_JSON_VALUE)
interface KakaoDirectionsApi {
  @GetExchange
  KakaoDirectionsResponse getDirections(
      @RequestParam("origin") String origin, @RequestParam("destination") String destination);
}
