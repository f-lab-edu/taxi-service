package com.giwankim.taxiservice.core.domain.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@Getter
public class TripEstimate {
  private final TaxiType taxiType;
  private final KRWMoney baseFare;
  private final Directions directions;

  @Builder
  public TripEstimate(TaxiType taxiType, KRWMoney baseFare, Directions directions) {
    this.taxiType = taxiType;
    this.baseFare = baseFare;
    this.directions = directions;
  }

  public static TripEstimate of(TaxiType taxiType, KRWMoney baseFare, Directions directions) {
    return new TripEstimate(taxiType, baseFare, directions);
  }

  public KRWMoney calculateTotalFare(Directions directions) {
    return taxiType.calculateTotalFare(baseFare, directions);
  }
}
