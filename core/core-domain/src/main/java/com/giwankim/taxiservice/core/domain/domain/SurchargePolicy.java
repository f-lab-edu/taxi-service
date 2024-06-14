package com.giwankim.taxiservice.core.domain.domain;

public interface SurchargePolicy {
  Money calculateSurchargeAmount(Money baseFare, Directions directions);
}
