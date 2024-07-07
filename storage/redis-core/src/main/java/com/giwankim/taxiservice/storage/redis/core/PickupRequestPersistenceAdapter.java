package com.giwankim.taxiservice.storage.redis.core;

import com.giwankim.taxiservice.core.domain.application.port.out.LoadPickupRequestPort;
import com.giwankim.taxiservice.core.domain.application.port.out.StorePickupRequestPort;
import com.giwankim.taxiservice.core.domain.application.port.out.UpdatePickupRequestStatePort;
import com.giwankim.taxiservice.core.domain.domain.PickupRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PickupRequestPersistenceAdapter
    implements StorePickupRequestPort, LoadPickupRequestPort, UpdatePickupRequestStatePort {
  private final PickupRequestRedisRepository pickupRequestRepository;
  private final PickupRequestMapper pickupRequestMapper;

  @Override
  public PickupRequest storePickupRequest(PickupRequest pickupRequest, Long ttlInSeconds) {
    PickupRequestRedisEntity pickupRequestEntity =
        pickupRequestMapper.mapToEntity(pickupRequest, ttlInSeconds);
    PickupRequestRedisEntity savedPickupRequestEntity =
        pickupRequestRepository.save(pickupRequestEntity);
    return pickupRequestMapper.mapToDomain(savedPickupRequestEntity);
  }

  @Override
  public PickupRequest loadPickupRequest(PickupRequest.RequestId id) {
    throw new UnsupportedOperationException(
        "PickupRequestPersistenceAdapter#loadPickupRequest not implemented yet!");
  }

  @Override
  public void updatePickupRequestState(PickupRequest pickupRequest) {
    throw new UnsupportedOperationException(
        "PickupRequestPersistenceAdapter#updatePickupRequestState not implemented yet!");
  }
}
