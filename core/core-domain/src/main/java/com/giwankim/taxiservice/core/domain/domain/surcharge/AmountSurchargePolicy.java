package com.giwankim.taxiservice.core.domain.domain.surcharge;

import com.giwankim.taxiservice.core.domain.domain.Directions;
import com.giwankim.taxiservice.core.domain.domain.Money;
import com.giwankim.taxiservice.core.domain.domain.SurchargePolicy;

public class AmountSurchargePolicy implements SurchargePolicy {
  private final Money surchargeAmount;

  public AmountSurchargePolicy(Money surchargeAmount) {
    this.surchargeAmount = surchargeAmount;
  }

  @Override
  public Money calculateSurchargeAmount(Money baseFare, Directions directions) {
    return surchargeAmount;
  }
}
