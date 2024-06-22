package com.giwankim.taxiservice.core.domain.domain;

import com.giwankim.taxiservice.core.domain.domain.surcharge.AmountSurchargePolicy;
import com.giwankim.taxiservice.core.domain.domain.surcharge.NoneSurchargePolicy;
import lombok.Getter;

@Getter
public enum TaxiType {
  REGULAR(new NoneSurchargePolicy()),
  DELUXE(new AmountSurchargePolicy(KRWMoney.wons(5_000))),
  JUMBO(new AmountSurchargePolicy(KRWMoney.wons(10_000)));

  private final SurchargePolicy surchargePolicy;

  TaxiType(SurchargePolicy surchargePolicy) {
    this.surchargePolicy = surchargePolicy;
  }

  public KRWMoney calculateTotalFare(KRWMoney baseFare, Directions directions) {
    KRWMoney surchargeAmount = surchargePolicy.calculateSurchargeAmount(baseFare, directions);
    return baseFare.plus(surchargeAmount);
  }
}
