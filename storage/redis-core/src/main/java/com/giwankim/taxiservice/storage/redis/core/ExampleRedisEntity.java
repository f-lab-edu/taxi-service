package com.giwankim.taxiservice.storage.redis.core;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("example")
@Getter
public class ExampleRedisEntity {
  @Id private String id;
  private String exampleField;

  @Builder
  public ExampleRedisEntity(String id, String exampleField) {
    this.id = id;
    this.exampleField = exampleField;
  }
}
