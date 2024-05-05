package com.giwankim.taxiservice.core.domain.application.port.in;

import com.giwankim.taxiservice.common.SelfValidating;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = false)
public class SearchLocationsQuery extends SelfValidating<SearchLocationsQuery> {
  @NotEmpty
  String keyword;

  @Min(1)
  @Max(45)
  Integer page;

  @Min(1)
  @Max(30)
  Integer size;

  public SearchLocationsQuery(String keyword,
                              Integer page,
                              Integer size) {
    this.keyword = keyword;
    this.page = page == null ? 1 : page;
    this.size = size == null ? 10 : size;
    this.validateSelf();
  }

  public SearchLocationsQuery(String keyword) {
    this(keyword, null, null);
  }
}
