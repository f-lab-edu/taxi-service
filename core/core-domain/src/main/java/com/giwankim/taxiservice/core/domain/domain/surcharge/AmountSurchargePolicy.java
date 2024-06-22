package com.giwankim.taxiservice.core.domain.domain.surcharge;

import com.giwankim.taxiservice.core.domain.domain.Directions;
import com.giwankim.taxiservice.core.domain.domain.KRWMoney;
import com.giwankim.taxiservice.core.domain.domain.SurchargePolicy;

public class AmountSurchargePolicy implements SurchargePolicy {
  private final KRWMoney surchargeAmount;

  public AmountSurchargePolicy(KRWMoney surchargeAmount) {
    this.surchargeAmount = surchargeAmount;
  }

  @Override
  public KRWMoney calculateSurchargeAmount(KRWMoney baseFare, Directions directions) {
    return surchargeAmount;
  }
}
