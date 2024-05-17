package com.giwankim.taxiservice.client.location;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.List;

@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public record LocationsResponse(Meta meta, List<Document> documents) {

  @JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
  @JsonIgnoreProperties(ignoreUnknown = true)
  record Document(String addressName,
                  AddressType addressType,
                  String x,
                  String y) {

  }

  enum AddressType {
    REGION, ROAD, REGION_ADDR, ROAD_ADDR
  }

  @JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
  record Meta(Integer totalCount, Integer pageableCount, Boolean isEnd) {
  }
}
