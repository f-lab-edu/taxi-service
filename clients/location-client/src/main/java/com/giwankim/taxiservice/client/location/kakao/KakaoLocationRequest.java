package com.giwankim.taxiservice.client.location.kakao;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KakaoLocationRequest {
  private String query;
  private Integer page;
  private Integer size;

  public KakaoLocationRequest(String query, Integer page, Integer size) {
    this.query = query;
    this.page = page;
    this.size = size;
  }
}
