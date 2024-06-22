package com.giwankim.taxiservice.core.domain.domain.surcharge;

import com.giwankim.taxiservice.core.domain.domain.Directions;
import com.giwankim.taxiservice.core.domain.domain.KRWMoney;
import com.giwankim.taxiservice.core.domain.domain.SurchargePolicy;

public class NoneSurchargePolicy implements SurchargePolicy {
  @Override
  public KRWMoney calculateSurchargeAmount(KRWMoney baseFare, Directions directions) {
    return KRWMoney.ZERO;
  }
}
