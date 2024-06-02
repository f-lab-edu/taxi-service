package com.giwankim.taxiservice.client.location.kakao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "kakao-location-api", url = "${location.kakao.api.url}")
interface KakaoLocationApi {

  @RequestMapping(method = RequestMethod.GET, value = "/search/address.json",
      consumes = MediaType.APPLICATION_JSON_VALUE)
  KakaoLocationResponse searchLocations(@SpringQueryMap KakaoLocationRequest request);
}
