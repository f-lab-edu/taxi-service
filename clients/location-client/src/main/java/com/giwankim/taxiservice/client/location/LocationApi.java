package com.giwankim.taxiservice.client.location;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "location-kakao-api", url = "${location.kakao.api.url}")
public interface LocationApi {

  @RequestMapping(method = RequestMethod.GET, value = "/search/address.json",
    consumes = MediaType.APPLICATION_JSON_VALUE)
  LocationsResponse searchLocations(@SpringQueryMap LocationRequest request);

}
