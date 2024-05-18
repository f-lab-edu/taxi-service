package com.giwankim.taxiservice.core.api.controller.v1.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record SearchLocationRequest(
  @NotBlank(message = "키워드를 입력하셔야 합니다.")
  @Size(max = 40, message = "키워드의 길이는 100 이하이어야 합니다.")
  String keyword,
  @Min(value = 1, message = "page 값은 1 이상이어야 합니다.")
  @Max(value = 45, message = "page 값은 45 이하이어야 합니다.")
  Integer page,
  @Min(value = 1, message = "size 값은 1 이상이어야 합니다.")
  @Max(value = 30, message = "size 값은 30 이하이어야 합니다.")
  Integer size
) {
  public SearchLocationRequest {
    page = page == null ? 1 : page;
    size = size == null ? 10 : size;
  }
}
