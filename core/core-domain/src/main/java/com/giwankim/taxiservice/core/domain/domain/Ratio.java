package com.giwankim.taxiservice.core.domain.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Ratio {
  private final double rate;

  public static Ratio valueOf(double rate) {
    return new Ratio(rate);
  }

  public Money of(Money money) {
    return money.times(rate);
  }
}
