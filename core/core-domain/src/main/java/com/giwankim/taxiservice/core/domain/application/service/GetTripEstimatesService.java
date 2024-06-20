package com.giwankim.taxiservice.core.domain.application.service;

import com.giwankim.taxiservice.core.domain.application.port.in.GetTripEstimatesQuery;
import com.giwankim.taxiservice.core.domain.application.port.in.GetTripEstimatesUseCase;
import com.giwankim.taxiservice.core.domain.application.port.in.TripEstimates;
import com.giwankim.taxiservice.core.domain.application.port.out.LoadBaseFarePort;
import com.giwankim.taxiservice.core.domain.application.port.out.LoadDirectionsPort;
import com.giwankim.taxiservice.core.domain.domain.Directions;
import com.giwankim.taxiservice.core.domain.domain.KRWMoney;
import com.giwankim.taxiservice.core.domain.domain.TaxiType;
import com.giwankim.taxiservice.core.domain.domain.TripEstimate;
import java.util.Arrays;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetTripEstimatesService implements GetTripEstimatesUseCase {

  private final LoadDirectionsPort loadDirectionsPort;
  private final LoadBaseFarePort loadBaseFarePort;

  @Override
  public TripEstimates getTripEstimates(GetTripEstimatesQuery query) {
    Directions directions = loadDirectionsPort.loadDirections(query.origin(), query.destination());
    KRWMoney baseFare = loadBaseFarePort.loadBaseFare(query.origin(), query.destination());
    List<TripEstimate> estimates =
        Arrays.stream(TaxiType.values())
            .map(taxiType -> TripEstimate.of(taxiType, baseFare, directions))
            .toList();
    return TripEstimates.from(estimates);
  }
}
