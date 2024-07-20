package com.giwankim.taxiservice.core.domain.application.service;

import static com.giwankim.taxiservice.domain.Fixtures.aPickupRequest;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

import com.giwankim.taxiservice.core.domain.application.port.in.RequestPickupCommand;
import com.giwankim.taxiservice.core.domain.application.port.out.StorePickupRequestPort;
import com.giwankim.taxiservice.core.domain.domain.PickupRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationEventPublisher;

@ExtendWith(MockitoExtension.class)
class RequestPickupServiceTest {
  @Mock private StorePickupRequestPort storePickupRequestPort;

  @Mock ApplicationEventPublisher applicationEventPublisher;

  @InjectMocks private RequestPickupService requestPickupService;

  @Test
  @DisplayName("배차 요청을 저장한다.")
  void should_persist_request_to_redis() {
    PickupRequest pickupRequest = aPickupRequest().build();
    given(storePickupRequestPort.storePickupRequest(any(PickupRequest.class), any(Long.class)))
        .willReturn(pickupRequest);

    RequestPickupCommand command =
        new RequestPickupCommand(
            pickupRequest.getPassenger(),
            pickupRequest.getPickup(),
            pickupRequest.getDropoff(),
            pickupRequest.getTaxiType(),
            300L);
    requestPickupService.requestPickup(command);

    then(storePickupRequestPort)
        .should(times(1))
        .storePickupRequest(any(PickupRequest.class), any(Long.class));
  }

  @Test
  @DisplayName("배차 요청 이벤트를 발행한다.")
  void should_publish_event() {
    PickupRequest pickupRequest = aPickupRequest().build();
    given(storePickupRequestPort.storePickupRequest(any(PickupRequest.class), any(Long.class)))
        .willReturn(pickupRequest);

    RequestPickupCommand command =
        new RequestPickupCommand(
            pickupRequest.getPassenger(),
            pickupRequest.getPickup(),
            pickupRequest.getDropoff(),
            pickupRequest.getTaxiType(),
            300L);
    requestPickupService.requestPickup(command);

    then(applicationEventPublisher)
        .should(times(1))
        .publishEvent(new PickupRequestSubmittedEvent(pickupRequest));
  }
}
