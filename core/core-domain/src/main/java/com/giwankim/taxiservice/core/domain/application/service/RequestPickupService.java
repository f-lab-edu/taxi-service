package com.giwankim.taxiservice.core.domain.application.service;

import com.giwankim.taxiservice.core.domain.application.port.in.RequestPickupCommand;
import com.giwankim.taxiservice.core.domain.application.port.in.RequestPickupUseCase;
import com.giwankim.taxiservice.core.domain.application.port.out.StorePickupRequestPort;
import com.giwankim.taxiservice.core.domain.domain.PickupRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RequestPickupService implements RequestPickupUseCase {
  private final StorePickupRequestPort storePickupRequestPort;
  private final ApplicationEventPublisher applicationEventPublisher;

  @Override
  public PickupRequest requestPickup(RequestPickupCommand command) {
    PickupRequest pickupRequest =
        storePickupRequestPort.storePickupRequest(command.toPickupRequest());
    applicationEventPublisher.publishEvent(new PickupRequestSubmittedEvent(pickupRequest));
    return pickupRequest;
  }
}
