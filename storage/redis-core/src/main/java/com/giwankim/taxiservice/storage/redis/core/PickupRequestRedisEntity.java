package com.giwankim.taxiservice.storage.redis.core;

import com.giwankim.taxiservice.core.domain.domain.PickupRequestStatus;
import com.giwankim.taxiservice.core.domain.domain.TaxiType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;

@RedisHash(value = "pickupRequest", timeToLive = 300)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class PickupRequestRedisEntity {
  @Id private String id;
  PickupRequestStatus status;
  private PassengerRedisEntity passenger;
  private LocationRedisEntity pickup;
  private LocationRedisEntity dropoff;
  private TaxiType taxiType;

  @TimeToLive private Long timeToLive;

  @Builder
  public PickupRequestRedisEntity(
      String id,
      PickupRequestStatus status,
      PassengerRedisEntity passenger,
      LocationRedisEntity pickup,
      LocationRedisEntity dropoff,
      TaxiType taxiType,
      Long timeToLive) {
    this.id = id;
    this.status = status;
    this.passenger = passenger;
    this.pickup = pickup;
    this.dropoff = dropoff;
    this.taxiType = taxiType;
    this.timeToLive = timeToLive;
  }
}
