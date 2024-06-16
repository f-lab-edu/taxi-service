package com.giwankim.taxiservice.core.domain.domain;

import com.giwankim.taxiservice.core.domain.domain.surcharge.AmountSurchargePolicy;
import com.giwankim.taxiservice.core.domain.domain.surcharge.NoneSurchargePolicy;
import com.giwankim.taxiservice.core.enums.TaxiType;
import lombok.Builder;
import lombok.Getter;

@Getter
public class TripEstimate {
  private final TaxiType taxiType;
  private final KRWMoney baseFare;
  private final SurchargePolicy surchargePolicy;

  @Builder
  public TripEstimate(TaxiType taxiType, KRWMoney baseFare, SurchargePolicy surchargePolicy) {
    this.taxiType = taxiType;
    this.baseFare = baseFare;
    this.surchargePolicy = surchargePolicy;
  }

  public static TripEstimate create(TaxiType taxiType, KRWMoney baseFare) {
    return switch (taxiType) {
      case REGULAR -> new TripEstimate(TaxiType.REGULAR, baseFare, new NoneSurchargePolicy());
      case DELUXE ->
          new TripEstimate(
              TaxiType.DELUXE, baseFare, new AmountSurchargePolicy(KRWMoney.wons(5_000)));
      case JUMBO ->
          new TripEstimate(
              TaxiType.JUMBO, baseFare, new AmountSurchargePolicy(KRWMoney.wons(10_000)));
    };
  }

  public KRWMoney calculateTotalFare(Directions directions) {
    KRWMoney surchargeAmount = surchargePolicy.calculateSurchargeAmount(baseFare, directions);
    return baseFare.plus(surchargeAmount);
  }
}
