package com.giwankim.taxiservice.core.domain.domain;

public interface SurchargePolicy {
  KRWMoney calculateSurchargeAmount(KRWMoney baseFare, Directions directions);
}
