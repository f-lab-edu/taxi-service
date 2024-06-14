package com.giwankim.taxiservice.core.domain.domain.surcharge;

import com.giwankim.taxiservice.core.domain.domain.Directions;
import com.giwankim.taxiservice.core.domain.domain.Money;
import com.giwankim.taxiservice.core.domain.domain.SurchargePolicy;

public class NoneSurchargePolicy implements SurchargePolicy {
  @Override
  public Money calculateSurchargeAmount(Money baseFare, Directions directions) {
    return Money.ZERO;
  }
}
