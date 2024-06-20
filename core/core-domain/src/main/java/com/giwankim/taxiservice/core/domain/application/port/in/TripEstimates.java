package com.giwankim.taxiservice.core.domain.application.port.in;

import com.giwankim.taxiservice.core.domain.domain.TaxiType;
import com.giwankim.taxiservice.core.domain.domain.TripEstimate;
import java.util.*;
import lombok.Builder;

public class TripEstimates {
  private final List<TripEstimate> estimates = new ArrayList<>();

  public TripEstimates(TripEstimate... estimates) {
    this(Arrays.asList(estimates));
  }

  @Builder
  public TripEstimates(List<TripEstimate> estimates) {
    this.estimates.addAll(estimates);
  }

  public List<TripEstimate> getEstimates() {
    return Collections.unmodifiableList(estimates);
  }

  public Optional<TripEstimate> findByTaxiType(TaxiType taxiType) {
    return estimates.stream()
        .filter(estimate -> estimate.getTaxiType().equals(taxiType))
        .findFirst();
  }
}
