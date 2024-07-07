package com.giwankim.taxiservice.storage.redis.core;

import com.giwankim.taxiservice.core.domain.domain.PickupRequestStatus;
import com.giwankim.taxiservice.core.domain.domain.TaxiType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;

@RedisHash(value = "pickupRequest", timeToLive = 300)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PickupRequestRedisEntity {
  @Id private String id;
  PickupRequestStatus status;
  private Long passengerId;
  private Point pickup;
  private Point dropoff;
  private TaxiType taxiType;

  @TimeToLive private Long timeToLive;

  @Builder
  public PickupRequestRedisEntity(
      String id,
      PickupRequestStatus status,
      Long passengerId,
      Point pickup,
      Point dropoff,
      TaxiType taxiType,
      Long timeToLive) {
    this.id = id;
    this.status = status;
    this.passengerId = passengerId;
    this.pickup = pickup;
    this.dropoff = dropoff;
    this.taxiType = taxiType;
    this.timeToLive = timeToLive;
  }
}
