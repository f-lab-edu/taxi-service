package com.giwankim.taxiservice.core.domain.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
public class TripEstimates {
  private final Directions directions;
  private final Money baseFare;
  private final List<TripEstimate> estimates = new ArrayList<>();

  public TripEstimates(Money baseFare, Directions directions, TripEstimate... estimates) {
    this(baseFare, directions, Arrays.asList(estimates));
  }

  @Builder
  public TripEstimates(Money baseFare, Directions directions, List<TripEstimate> estimates) {
    this.baseFare = baseFare;
    this.directions = directions;
    this.estimates.addAll(estimates);
  }
}
