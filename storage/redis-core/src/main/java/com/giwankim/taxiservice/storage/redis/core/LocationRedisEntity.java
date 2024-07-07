package com.giwankim.taxiservice.storage.redis.core;

import com.giwankim.taxiservice.core.domain.domain.Location;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.geo.Point;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class LocationRedisEntity {
  private String name;
  private Point point;

  @Builder
  public LocationRedisEntity(String name, Point point) {
    this.name = name;
    this.point = point;
  }

  public LocationRedisEntity(Location location) {
    this(location.getName(), new Point(location.getLongitude(), location.getLatitude()));
  }
}
