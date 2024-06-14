package com.giwankim.taxiservice.core.domain.domain.surcharge;

import com.giwankim.taxiservice.core.domain.domain.Directions;
import com.giwankim.taxiservice.core.domain.domain.Money;
import com.giwankim.taxiservice.core.domain.domain.SurchargePolicy;

public class PercentSurchargePolicy implements SurchargePolicy {
  private final double percent;

  public PercentSurchargePolicy(double percent) {
    this.percent = percent;
  }

  @Override
  public Money calculateSurchargeAmount(Money baseFare, Directions directions) {
    return baseFare.times(percent);
  }
}
