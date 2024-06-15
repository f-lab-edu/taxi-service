package com.giwankim.taxiservice.client.location.kakao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.giwankim.taxiservice.core.domain.domain.Location;
import java.util.List;

@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public record KakaoLocationResponse(Meta meta, List<Document> documents) {

  List<Location> toLocations() {
    return documents().stream()
        .map(document -> new Location(document.addressName(), document.y(), document.x()))
        .toList();
  }

  @JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
  @JsonIgnoreProperties(ignoreUnknown = true)
  record Document(String addressName, AddressType addressType, Double x, Double y) {}

  enum AddressType {
    REGION,
    ROAD,
    REGION_ADDR,
    ROAD_ADDR
  }

  @JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
  record Meta(Integer totalCount, Integer pageableCount, Boolean isEnd) {}
}
