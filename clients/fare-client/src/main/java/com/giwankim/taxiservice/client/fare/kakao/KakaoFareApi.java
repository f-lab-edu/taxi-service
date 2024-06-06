package com.giwankim.taxiservice.client.fare.kakao;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "kakao-fare-api", url = "${fare.kakao.api.url}")
interface KakaoFareApi {
  @RequestMapping(
      method = RequestMethod.GET,
      value = "/v1/directions",
      consumes = APPLICATION_JSON_VALUE)
  KakaoFareResponse getFare(@SpringQueryMap KakaoFareRequest request);
}
